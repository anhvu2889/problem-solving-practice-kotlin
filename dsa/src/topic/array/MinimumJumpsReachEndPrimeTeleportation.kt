package topic.array

/**
 * 3629. Minimum Jumps to Reach End via Prime Teleportation
 * Time:
 * Space:
 */
class MinimumJumpsReachEndPrimeTeleportation {
    fun minJumps(nums: IntArray): Int {
        val n = nums.size
        if (n == 1) return 0

        val maxVal = nums.maxOrNull() ?: 0
        val spf = buildSpfLinear(maxVal)

        val factorToIndices = HashMap<Int, MutableList<Int>>()

        for (i in nums.indices) {
            var x = nums[i]

            while (x > 1) {
                val factor = spf[x]
                factorToIndices.getOrPut(factor) { mutableListOf() }.add(i)

                while (x % factor == 0) {
                    x /= factor
                }
            }
        }

        val queue = ArrayDeque<Int>()
        val visited = BooleanArray(n)

        queue.addLast(0)
        visited[0] = true

        var steps = 0

        while (queue.isNotEmpty()) {
            val size = queue.size

            repeat(size) {
                val i = queue.removeFirst()

                if (i == n - 1) return steps

                val left = i - 1
                if (left >= 0 && !visited[left]) {
                    visited[left] = true
                    queue.addLast(left)
                }

                val right = i + 1
                if (right < n && !visited[right]) {
                    visited[right] = true
                    queue.addLast(right)
                }

                val value = nums[i]

                if (value >= 2 && spf[value] == value) {
                    val targets = factorToIndices[value]

                    if (targets != null) {
                        for (next in targets) {
                            if (!visited[next]) {
                                visited[next] = true
                                queue.addLast(next)
                            }
                        }

                        factorToIndices.remove(value)
                    }
                }
            }

            steps++
        }

        return -1
    }

    private fun buildSpfLinear(maxVal: Int): IntArray {
        val spf = IntArray(maxVal + 1)
        val primes = mutableListOf<Int>()

        for (x in 2..maxVal) {
            if (spf[x] == 0) {
                spf[x] = x
                primes.add(x)
            }

            for (p in primes) {
                val value = x.toLong() * p

                if (value > maxVal || p > spf[x]) {
                    break
                }

                spf[value.toInt()] = p
            }
        }

        return spf
    }
}
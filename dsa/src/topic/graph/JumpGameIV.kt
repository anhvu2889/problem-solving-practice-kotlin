package topic.graph

/**
 * 1345. Jump Game IV
 * Time: O(n)
 * Space: O(1)
 */
class JumpGameIV {
    fun minJumps(arr: IntArray): Int {
        val n = arr.size
        if (n < 3)
            return n - 1
        val map = HashMap<Int, MutableList<Int>>()
        for (i in arr.indices) {
            val num = arr[i]
            map.getOrPut(num) { mutableListOf() }.add(i)
        }
        val visited = BooleanArray(n)
        val queue = ArrayDeque<Int>()
        queue.addLast(0)
        visited[0] = true
        var steps = 0
        while (queue.isNotEmpty()) {
            val size = queue.size
            repeat(size) {
                val curIndex = queue.removeFirst()
                val num = arr[curIndex]
                if (curIndex == n - 1) {
                    return steps
                }
                for (i in intArrayOf(curIndex - 1, curIndex + 1)) {
                    if (i in 0 until n && !visited[i]) {
                        queue.addLast(i)
                        visited[i] = true
                    }
                }
                if (map.containsKey(num)) {
                    val sameValuesIndices = map[num]!!
                    for (i in sameValuesIndices) {
                        if (i != curIndex && !visited[i]) {
                            queue.addLast(i)
                            visited[i] = true
                        }

                    }
                    map.remove(num)
                }
            }
            steps++
        }
        return steps
    }
}
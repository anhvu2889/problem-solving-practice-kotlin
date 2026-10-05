package topic.hashmap

class HouseSegmentsAfterDeletions {
    fun segmentsAfterOps(houses: IntArray, queries: IntArray): IntArray {
        val aliveSet = HashSet<Int>()
        for (house in houses) {
            aliveSet.add(house)
        }
        var segments = countStart(houses, aliveSet)
        val ans = IntArray(queries.size)
        for (i in queries.indices) {
            val value = queries[i]
            val isLeftAlive = aliveSet.contains(value - 1)
            val isRightAlive = aliveSet.contains(value + 1)
            if (isLeftAlive && isRightAlive) {
                segments++
            } else if (!isLeftAlive && !isRightAlive) {
                segments--
            }
            aliveSet.remove(value)
            ans[i] = segments
        }
        return ans
    }

    private fun countStart(houses: IntArray, aliveSet: HashSet<Int>): Int {
        var count = 0
        for (house in houses) {
            if (!aliveSet.contains(house - 1)) {
                count++
            }
        }
        return count
    }
}
package topic.array

/**
 * 1840. Maximum Building Height
 * Time: O(m *log(m))
 * Space: O(m)
 */
class MaximumBuildingHeight {
    fun maxBuilding(n: Int, restrictions: Array<IntArray>): Int {
        val limits = mutableListOf<IntArray>()
        limits.add(intArrayOf(1, 0))
        limits.add(intArrayOf(n, n - 1))
        limits.addAll(restrictions)
        limits.sortBy { it[0] }
        for (i in 1 until limits.size) {
            val dist = limits[i][0] - limits[i - 1][0]
            limits[i][1] = minOf(limits[i][1], limits[i - 1][1] + dist)
        }
        for (i in limits.size - 2 downTo 0) {
            val dist = limits[i + 1][0] - limits[i][0]
            limits[i][1] = minOf(limits[i][1], limits[i + 1][1] + dist)
        }
        var max = 0
        for (i in 0 until limits.size - 1) {
            val leftPos = limits[i][0]
            val leftHeight = limits[i][1]
            val rightPos = limits[i + 1][0]
            val rightHeight = limits[i + 1][1]
            val dist = rightPos - leftPos
            val peak = (leftHeight + rightHeight + dist) / 2
            max = maxOf(max, peak)
        }
        return max
    }
}
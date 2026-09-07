package topic.mergeinterval

/**
 * 986. Interval List Intersections
 * Time: O(m + n)
 * Space: O(min(m, n))
 */
class IntervalListIntersections {
    fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
        val ans = mutableListOf<IntArray>()
        var i = 0
        var j = 0
        while (i < firstList.size && j < secondList.size) {
            val l = maxOf(firstList[i][0], secondList[j][0])
            val r = minOf(firstList[i][1], secondList[j][1])
            if (l <= r) {
                ans.add(intArrayOf(l, r))
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++
            } else {
                j++
            }
        }
        return ans.toTypedArray()
    }
}
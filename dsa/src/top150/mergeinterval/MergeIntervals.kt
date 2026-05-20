package top150.mergeinterval

/**
 * 56. Merge Intervals
 * Time: O(n*log(n))
 * Space: O(n)
 */
class MergeIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.size == 1)
            return intervals
        intervals.sortBy { it[0] }
        val ans = mutableListOf<IntArray>()
        ans.add(intervals[0])
        for (i in 1 until intervals.size) {
            val last = ans.last()
            val cur = intervals[i]
            if (cur[0] <= last[1]) {
                last[1] = maxOf(last[1], cur[1])
            } else {
                ans.add(cur)
            }
        }
        return ans.toTypedArray()
    }
}
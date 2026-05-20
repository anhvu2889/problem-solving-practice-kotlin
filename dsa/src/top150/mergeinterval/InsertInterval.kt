package top150.mergeinterval

/**
 * 57. Insert Interval
 * Time: O(n)
 * Space: O(n)
 */
class InsertInterval {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val ans = mutableListOf<IntArray>()
        var start = newInterval[0]
        var end = newInterval[1]
        var i = 0
        val n = intervals.size
        while (i < n && intervals[i][1] < start) {
            ans.add(intervals[i])
            i++
        }
        while (i < n && intervals[i][0] <= end) {
            start = minOf(start, intervals[i][0])
            end = maxOf(end, intervals[i][1])
            i++
        }
        ans.add(intArrayOf(start, end))
        while (i < n) {
            ans.add(intervals[i])
            i++
        }
        return ans.toTypedArray()
    }
}
package blind75.interval

/**
 * 435. Non-overlapping Intervals
 * Time: O(nlog(n))
 * Space: O(1)
 */
class NonOverlappingIntervals {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        var count = 0
        var prevEnd = Int.MIN_VALUE
        intervals.sortBy { it[1] }
        for (interval in intervals) {
            if (interval[0] >= prevEnd) {
                prevEnd = interval[1]
            } else {
                count++
            }
        }
        return count
    }
}
package topic.mergeinterval

import java.util.*

/**
 * 1288. Remove Covered Intervals
 * Time: O(nlog(n))
 * Space: O(1)
 */
class RemoveCoveredInterval {
    fun removeCoveredIntervals(intervals: Array<IntArray>): Int {
        Arrays.sort(intervals) { a, b ->
            if (a[0] != b[0]) {
                a[0] - b[0]
            } else {
                b[1] - a[1]
            }
        }
        var count = 0
        var end = 0
        for (interval in intervals) {
            if (end < interval[1]) {
                count++
                end = interval[1]
            }
        }
        return count
    }
}
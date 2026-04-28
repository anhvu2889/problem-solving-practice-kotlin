package blind75.interval

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 * Time:
 * Space:
 */
class MinimumNumberArrowsBurstBalloons {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        points.sortBy { it[1] }
        var count = 1
        var arrowPos = points[0][1]
        for (i in 1..<points.size) {
            if (points[i][0] > arrowPos) {
                arrowPos = points[i][1]
                count++
            }
        }
        return count
    }
}
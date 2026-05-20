package top150.mergeinterval

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 * Time: O(n)
 * Space: O(1)
 */
class MinimumNumberArrowsBurstBalloons {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        points.sortBy { it[1] }
        var arrow = points[0][1]
        var count = 1
        for (i in 1 until points.size) {
            if (points[i][0] > arrow) {
                arrow = points[i][1]
                count++
            }
        }
        return count
    }
}
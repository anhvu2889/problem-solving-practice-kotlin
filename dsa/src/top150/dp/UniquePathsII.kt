package top150.dp

/**
 * 63. Unique Paths II
 * Time: O(m * n)
 * Space: O(n)
 */
class UniquePathsII {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val m = obstacleGrid.size
        val n = obstacleGrid[0].size
        var dp = IntArray(n)
        if (obstacleGrid[0][0] == 0)
            dp[0] = 1
        for (row in obstacleGrid) {
            for (c in 0 until n) {
                if (row[c] == 1) {
                    dp[c] = 0
                } else if (c > 0) {
                    dp[c] += dp[c - 1]
                }
            }
        }
        return dp[n - 1]
    }
}
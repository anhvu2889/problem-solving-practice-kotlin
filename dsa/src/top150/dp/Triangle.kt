package top150.dp

/**
 * 120. Triangle
 * Time: O(h ^ 2)
 * Space: O(h)
 */
class Triangle {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val h = triangle.size
        val dp = IntArray(h)
        dp[0] = triangle[0][0]
        for (level in 1..<h) {
            dp[level] = triangle[level][level] + dp[level - 1]
            for (i in level - 1 downTo 1) {
                dp[i] = minOf(dp[i], dp[i - 1]) + triangle[level][i]
            }
            dp[0] += triangle[level][0]
        }
        return dp.min()
    }
}
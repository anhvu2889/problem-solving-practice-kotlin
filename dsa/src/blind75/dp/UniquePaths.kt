package blind75.dp

/**
 * 62. Unique Paths
 * Time: O(m * n)
 * Space: O(m * n)
 */
class UniquePaths {
    fun uniquePaths(m: Int, n: Int): Int {
        val grid = Array(m) { IntArray(n) }
        for (row in 0 until m) {
            grid[row][0] = 1
        }
        for (col in 0 until n) {
            grid[0][col] = 1
        }
        for (row in 1 until m) {
            for (col in 1 until n) {
                grid[row][col] = grid[row - 1][col] + grid[row][col - 1]
            }
        }
        return grid[m - 1][n - 1]
    }
}
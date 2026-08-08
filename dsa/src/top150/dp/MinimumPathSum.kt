package top150.dp

/**
 * 64. Minimum Path Sum
 * Time: O(m * n)
 * Space: O(1)
 */
class MinimumPathSum {
    fun minPathSum(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        for (r in 0 until m) {
            for (c in 0 until n) {
                if (r == 0 && c == 0)
                    continue
                val fromTop = if (r - 1 in 0 until m) grid[r - 1][c] else Int.MAX_VALUE
                val fromLeft = if (c - 1 in 0 until n) grid[r][c - 1] else Int.MAX_VALUE
                grid[r][c] = grid[r][c] + minOf(fromLeft, fromTop)
            }
        }
        return grid[m - 1][n - 1]
    }
}
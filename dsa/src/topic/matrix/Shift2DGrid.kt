package topic.matrix

/**
 * 1260. Shift 2D Grid
 * Time: O(m * n)
 * Space: O(m * n)
 */
class Shift2DGrid {
    fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
        val m = grid.size
        val n = grid[0].size
        val d = k % (m * n)
        rotate(grid, 0, m * n - 1)
        rotate(grid, 0, d - 1)
        rotate(grid, d, m * n - 1)
        val ans = mutableListOf<List<Int>>()
        return grid.map { it.toList() }
    }

    private fun rotate(grid: Array<IntArray>, start: Int, end: Int) {
        val n = grid[0].size
        var l = start
        var r = end
        while (l < r) {
            val r1 = l / n
            val c1 = l % n
            val r2 = r / n
            val c2 = r % n
            val temp = grid[r1][c1]
            grid[r1][c1] = grid[r2][c2]
            grid[r2][c2] = temp
            l++
            r--
        }
    }
}
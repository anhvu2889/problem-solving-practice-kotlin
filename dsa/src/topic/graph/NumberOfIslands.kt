package topic.graph

/**
 * 200. Number of Islands
 */
class NumberOfIslands {

    fun numIslands(grid: Array<CharArray>): Int {
        var count = 0
        val rows = grid.size
        val cols = grid[0].size
        for (row in 0 until rows) {
            for (col in 0 until cols) {
                if (grid[row][col] == '1') {
                    bfs(grid, row, col, rows, cols)
                    count++
                }
            }
        }
        return count
    }

    fun bfs(grid: Array<CharArray>, row: Int, col: Int, m: Int, n: Int) {
        val queue = ArrayDeque<IntArray>()
        val adj = intArrayOf(-1, 0, 1, 0, -1)
        grid[row][col] = '*'
        queue.add(intArrayOf(row, col))
        while (queue.isNotEmpty()) {
            val cell = queue.removeLast()
            for (i in 0 until 4) {
                val nextRow = cell[0] + adj[i]
                val nextCol = cell[1] + adj[i + 1]
                if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n)
                    continue
                if (grid[nextRow][nextCol] == '1') {
                    queue.addFirst(intArrayOf(nextRow, nextCol))
                    grid[nextRow][nextCol] = '*'
                }
            }
        }
    }
}
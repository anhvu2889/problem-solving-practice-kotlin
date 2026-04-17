package blind75.graph

/**
 * 994. Rotting Oranges
 * Time: 0(m * n)
 * Space: O(m * n)
 */
class RottingOranges {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val adj = intArrayOf(1, 0, -1, 0, 1)
        var fresh = 0
        val queue = ArrayDeque<Pair<Int, Int>>()
        for (row in 0 until m) {
            for (col in 0 until n) {
                if (grid[row][col] == 2) {
                    queue.addLast(row to col)
                } else if (grid[row][col] == 1) {
                    fresh++
                }
            }
        }
        if (fresh == 0) {
            return 0
        }
        var minutes = 0
        while (queue.isNotEmpty() && fresh > 0) {
            val size = queue.size
            repeat(size) {
                val (row, col) = queue.removeFirst()
                for (i in 0 until 4) {
                    val adjRow = row + adj[i]
                    val adjCol = col + adj[i + 1]
                    if (adjRow !in 0..<m || adjCol !in 0..<n)
                        continue
                    if (grid[adjRow][adjCol] == 1) {
                        queue.addLast(adjRow to adjCol)
                        grid[adjRow][adjCol] = 2
                        fresh--
                    }
                }
            }
            minutes++
        }
        return if (fresh == 0) minutes else -1
    }
}
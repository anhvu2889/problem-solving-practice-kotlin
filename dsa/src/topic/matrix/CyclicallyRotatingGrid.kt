package topic.matrix

/**
 * 1914. Cyclically Rotating a Grid
 * Time: O(m * n)
 * Space: O(m + n)
 */
class CyclicallyRotatingGrid {
    fun rotateGrid(grid: Array<IntArray>, k: Int): Array<IntArray> {
        val m = grid.size
        val n = grid[0].size
        val result = Array(m) { IntArray(n) }
        val layers = minOf(m, n) / 2
        for (layer in 0 until layers) {
            val coordination = mutableListOf<Coordination>()
            val left = layer
            val right = n - 1 - layer
            val top = layer
            val bot = m - layer - 1
            for (col in left..right) {
                coordination.add(Coordination(top, col))
            }
            for (row in top + 1..bot) {
                coordination.add(Coordination(row, right))
            }
            for (col in right - 1 downTo left) {
                coordination.add(Coordination(bot, col))
            }
            for (row in bot - 1 downTo left + 1) {
                coordination.add(Coordination(row, left))
            }
            val layerLength = coordination.size
            val shilf = k % layerLength
            for (i in 0 until layerLength) {
                val sourceIndex = (i + shilf) % layerLength
                val targetCoordination = coordination[i]
                val sourceCoordination = coordination[sourceIndex]
                result[targetCoordination.row][targetCoordination.col] =
                    grid[sourceCoordination.row][sourceCoordination.col]
            }
        }

        return result
    }

    data class Coordination(val row: Int, val col: Int)
}
package topic.matrix

/**
 * 1861. Rotating the Box
 * Time: O(m * n)
 * Space O(1)
 */
class RotatingBox {
    fun rotateTheBox(boxGrid: Array<CharArray>): Array<CharArray> {
        val m = boxGrid.size
        val n = boxGrid[0].size
        for (row in 0 until m) {
            var r = n - 1
            for (l in n - 1 downTo 0) {
                if (boxGrid[row][l] == '*') {
                    r = l - 1
                }
                if (boxGrid[row][l] == '#') {
                    boxGrid[row][l] = '.'
                    boxGrid[row][r] = '#'
                    r--
                }
            }
        }
        val grid = Array(n) { CharArray(m) }
        for (row in 0 until m) {
            for (col in 0 until n) {
                grid[col][m - 1 - row] = boxGrid[row][col]
            }
        }
        return grid
    }
}
package top150.matrix

/**
 * 48. Rotate Image
 * Time: O(n^2)
 * Space: O(1)
 */
class RotateImage {
    fun rotate(matrix: Array<IntArray>): Unit {
        val n = matrix.size
        for (row in matrix.indices) {
            for (col in row + 1 until n) {
                val temp = matrix[row][col]
                matrix[row][col] = matrix[col][row]
                matrix[col][row] = temp
            }
        }
        for (row in 0 until n) {
            var l = 0
            var r = n - 1
            while (l < r) {
                val temp = matrix[row][l]
                matrix[row][l] = matrix[row][r]
                matrix[row][r] = temp
                l++
                r--
            }
        }
    }
}
package top150.matrix

/**
 * 73. Set Matrix Zeroes
 * Time: O(m * n)
 * Space: O(1)
 */
class SetMatrixZeroes {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val rows = matrix.size
        val cols = matrix[0].size
        var firstRowHasZero = false
        var firstColHasZero = false
        for (r in 0 until rows) {
            if (matrix[r][0] == 0) {
                firstColHasZero = true
                break
            }
        }
        for (c in 0 until cols) {
            if (matrix[0][c] == 0) {
                firstRowHasZero = true
                break
            }
        }
        for (r in 1 until rows) {
            for (c in 1 until cols) {
                if (matrix[r][c] == 0) {
                    matrix[0][c] = 0
                    matrix[r][0] = 0
                }
            }
        }
        for (r in 1 until rows) {
            for (c in 1 until cols) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0)
                    matrix[r][c] = 0
            }
        }
        if (firstColHasZero) {
            for (r in 0 until rows) {
                matrix[r][0] = 0
            }
        }
        if (firstRowHasZero) {
            for (c in 0 until cols) {
                matrix[0][c] = 0
            }
        }
    }
}
package top150.matrix

/**
 * 54. Spiral Matrix
 * Time: O( m * n)
 * Space: O(1)
 */
class SpiralMatrix {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val ans = mutableListOf<Int>()
        val rows = matrix.size
        val cols = matrix[0].size
        var top = 0
        var bot = rows - 1
        var left = 0
        var right = cols - 1
        while (top <= bot && left <= right) {
            for (col in left..right)
                ans.add(matrix[top][col])
            top++
            for (row in top..bot)
                ans.add(matrix[row][right])
            right--
            if (top <= bot) {
                for (col in right downTo left)
                    ans.add(matrix[bot][col])
                bot--
            }
            if (left <= right) {
                for (row in bot downTo top)
                    ans.add(matrix[row][left])
                left++
            }
        }
        return ans
    }
}
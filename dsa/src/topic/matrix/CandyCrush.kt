package topic.matrix

import kotlin.math.abs

/**
 * 723. Candy Crush
 * Time: O ((m * n) ^ 2)
 * Space: O(1)
 */
class CandyCrush {
    fun candyCrush(board: Array<IntArray>): Array<IntArray> {
        val rows = board.size
        val cols = board[0].size
        var stable = false
        while (!stable) {
            stable = true
            for (row in rows - 1 downTo 0) {
                for (col in 2 until cols) {
                    val value = abs(board[row][col])
                    if (value != 0 && value == abs(board[row][col - 1]) && value == abs(board[row][col - 2])) {
                        stable = false
                        for (i in 0..2) {
                            board[row][col - i] = -value
                        }
                    }
                }
            }
            for (col in 0 until cols) {
                for (row in 2 until rows) {
                    val value = abs(board[row][col])
                    if (value != 0 && value == abs(board[row - 1][col]) && value == abs(board[row - 2][col])) {
                        stable = false
                        for (i in 0..2) {
                            board[row - i][col] = -value
                        }
                    }
                }
            }
            for (col in 0 until cols) {
                var w = rows - 1
                for (r in rows - 1 downTo 0) {
                    if (board[r][col] > 0) {
                        board[w][col] = board[r][col]
                        w--
                    }
                }
                while (w >= 0) {
                    board[w][col] = 0
                    w--
                }
            }
        }
        return board
    }
}
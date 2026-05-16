package top150.matrix

/**
 * 36. Valid Sudoku
 * Time:
 * Space:
 */
class ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val n = board.size
        val seenCol = Array(9) { BooleanArray(9) }
        val seenRow = Array(9) { BooleanArray(9) }
        val seenBox = Array(9) { BooleanArray(9) }
        for (row in 0 until 9) {
            for (col in 0 until 9) {
                val c = board[row][col]
                if (c == '.')
                    continue
                val digit = c - '1'
                val boxIndex = (row / 3) * 3 + (col / 3)
                if (seenRow[row][digit] || seenCol[col][digit] || seenBox[boxIndex][digit])
                    return false
                seenRow[row][digit] = true
                seenCol[col][digit] = true
                seenBox[boxIndex][digit] = true
            }
        }
        return true
    }
}
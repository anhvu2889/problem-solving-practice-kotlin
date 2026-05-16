package top150.matrix

/**
 * 289. Game of Life
 * Time:O(m * n)
 * Space: O(1)
 */
class GameOfLife {
    fun gameOfLife(board: Array<IntArray>): Unit {
        val dirs = arrayOf(
            intArrayOf(-1, -1),
            intArrayOf(-1, 0),
            intArrayOf(-1, 1),
            intArrayOf(0, -1),
            intArrayOf(0, 1),
            intArrayOf(1, -1),
            intArrayOf(1, 0),
            intArrayOf(1, 1)
        )
        val rows = board.size
        val cols = board[0].size
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                var live = 0
                for (dir in dirs) {
                    val nr = r + dir[0]
                    val nc = c + dir[1]
                    if (nr in 0 until rows && nc in 0 until cols && board[nr][nc] in 1..2)
                        live++
                }
                if (board[r][c] == 1) {
                    if (live < 2 || live > 3)
                        board[r][c] = 2
                } else {
                    if (live == 3)
                        board[r][c] = 3
                }
            }
        }
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (board[r][c] == 1 || board[r][c] == 3) {
                    board[r][c] = 1
                } else {
                    board[r][c] = 0
                }
            }
        }
    }
}
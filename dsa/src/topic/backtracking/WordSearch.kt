package topic.backtracking

/**
 * 79. Word Search
 * Time: O(m x n x 4^l)
 * Space: O(1)
 */
class WordSearch {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        for (row in board.indices) {
            for (col in board[row].indices) {
                if (dfs(board, word, 0, col, row))
                    return true
            }
        }
        return false
    }

    fun dfs(board: Array<CharArray>, word: String, index: Int, col: Int, row: Int): Boolean {
        if (index == word.length) {
            return true
        }

        if (col < 0 || col >= board[0].size || row < 0 || row >= board.size) {
            return false
        }

        if (board[row][col] != word[index]) {
            return false
        }
        val temp = board[row][col]
        board[row][col] = '.'
        val result = dfs(board, word, index + 1, col + 1, row)
                || dfs(board, word, index + 1, col - 1, row)
                || dfs(board, word, index + 1, col, row - 1)
                || dfs(board, word, index + 1, col, row + 1)
        board[row][col] = temp
        return result
    }
}
package top150.graph

/**
 * 130. Surrounded Regions
 * Time: O(m * n)
 * Space: O(m * n)
 */
class SurroundedRegions {
    fun solve(board: Array<CharArray>): Unit {
        val m = board.size
        val n = board[0].size
        val visited = HashSet<Pair<Int, Int>>()
        for (r in 0..<m) {
            if (board[r][0] == 'O')
                bfs(board, m, n, Pair(r, 0))
            if (board[r][n - 1] == 'O')
                bfs(board, m, n, Pair(r, n - 1))
        }
        for (c in 0..<n) {
            if (board[0][c] == 'O')
                bfs(board, m, n, Pair(0, c))
            if (board[m - 1][c] == 'O')
                bfs(board, m, n, Pair(m - 1, c))
        }
        for (r in 0..<m) {
            for (c in 0..<n) {
                if (board[r][c] == 'O')
                    board[r][c] = 'X'
                else if (board[r][c] == 'S')
                    board[r][c] = 'O'
            }
        }
    }

    private fun bfs(
        board: Array<CharArray>,
        m: Int,
        n: Int,
        source: Pair<Int, Int>
    ) {
        val dR = intArrayOf(0, 0, 1, -1)
        val dC = intArrayOf(1, -1, 0, 0)
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.addFirst(source)
        board[source.first][source.second] = 'S'
        while (queue.isNotEmpty()) {
            val cur = queue.removeLast()
            for (i in 0..<4) {
                val r = cur.first + dR[i]
                val c = cur.second + dC[i]
                if (r !in 0..<m || c !in 0..<n)
                    continue
                if (board[r][c] == 'O') {
                    queue.addFirst(Pair(r, c))
                    board[r][c] = 'S'
                }
            }
        }
    }
}
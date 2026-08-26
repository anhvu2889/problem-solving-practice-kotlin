package top150.graph

/**
 * 909. Snakes and Ladders
 * Time: O(n ^ 2)
 * Space: O(n ^ 2)
 */
class SnakeAndLadders {
    fun snakesAndLadders(board: Array<IntArray>): Int {
        val n = board.size
        val src = 1
        val des = n * n
        val queue = ArrayDeque<Int>()
        val visited = BooleanArray(des + 1)
        var steps = 0
        visited[src] = true
        queue.addFirst(src)
        while (queue.isNotEmpty()) {
            steps++
            repeat(queue.size) {
                val cur = queue.removeLast()
                val max = minOf(cur + 6, des)
                for (adj in cur + 1..max) {
                    val value = getValue(adj, board)
                    val next = if (value == -1) adj else value
                    if (next == des) {
                        return steps
                    }
                    if (visited[next]) {
                        continue
                    }
                    visited[next] = true
                    queue.addFirst(next)
                }
            }
        }
        return -1

    }

    private fun getValue(index: Int, board: Array<IntArray>): Int {
        val n = board.size
        val rowFromBottom = (index - 1) / n
        val r = n - 1 - rowFromBottom
        val c = if (rowFromBottom % 2 == 0) {
            (index - 1) % n
        } else {
            n - 1 - (index - 1) % n
        }
        return board[r][c]
    }
}
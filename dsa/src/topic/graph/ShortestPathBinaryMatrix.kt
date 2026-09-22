package topic.graph

/**
 * 1091. Shortest Path in Binary Matrix
 * Time: O(n ^ 2)
 * Space: O(n ^ 2)
 */
class ShortestPathBinaryMatrix {
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        val n = grid.size
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1
        }
        if (n == 1) {
            return 1
        }
        val queue = ArrayDeque<Pair<Int, Int>>()
        val dist = Array(n) { IntArray(n) { -1 } }
        val dr = intArrayOf(0, 0, -1, 1, 1, -1, 1, -1)
        val dc = intArrayOf(1, -1, 0, 0, -1, 1, 1, -1)
        queue.addLast(Pair(0, 0))
        dist[0][0] = 1
        while (queue.isNotEmpty()) {
            val size = queue.size
            repeat(size) {
                val cur = queue.removeFirst()
                val r = cur.first
                val c = cur.second
                for (i in 0 until 8) {
                    val nr = r + dr[i]
                    val nc = c + dc[i]
                    if (nr !in 0 until n || nc !in 0 until n) {
                        continue
                    }
                    if (grid[nr][nc] == 1) {
                        continue
                    }
                    if (dist[nr][nc] != -1) {
                        continue
                    }
                    dist[nr][nc] = dist[r][c] + 1
                    if (nr == n - 1 && nc == n - 1) {
                        return dist[nr][nc]
                    }
                    queue.addLast(Pair(nr, nc))
                }
            }
        }
        return -1
    }
}
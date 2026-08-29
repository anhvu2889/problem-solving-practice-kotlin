package topic.graph

/**
 * 542. 01 Matrix
 * Time: O(m * n)
 * Space: O(m * n)
 */
class `01Matrix` {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val m = mat.size
        val n = mat[0].size
        val dist = Array(m) { IntArray(n) { -1 } }
        val queue = ArrayDeque<Pair<Int, Int>>()
        val dr = listOf(0, 0, -1, 1)
        val dc = listOf(-1, 1, 0, 0)
        for (r in 0 until m) {
            for (c in 0 until n) {
                if (mat[r][c] == 0) {
                    dist[r][c] = 0
                    queue.addLast(Pair(r, c))
                }
            }
        }
        while (queue.isNotEmpty()) {
            val (r, c) = queue.removeFirst()
            for (i in 0 until 4) {
                val nr = r + dr[i]
                val nc = c + dc[i]
                if (nr !in 0 until m || nc !in 0 until n) {
                    continue
                }
                if (dist[nr][nc] != -1) {
                    continue
                }
                dist[nr][nc] = dist[r][c] + 1
                queue.addLast(Pair(nr, nc))
            }
        }
        return dist
    }
}
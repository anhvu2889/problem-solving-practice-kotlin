package topic.graph

class MinimumObstacleRemovalReachCorner {
    fun minimumObstacles(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val dr = listOf(0, 0, 1, -1)
        val dc = listOf(1, -1, 0, 0)
        val INF = m * n
        val dist = Array(m) { IntArray(n) { INF } }
        val deque = ArrayDeque<IntArray>()
        dist[0][0] = 0
        deque.addLast(intArrayOf(0, 0, 0))
        while (deque.isNotEmpty()) {
            val (r, c, d) = deque.removeFirst()
            if (d > dist[r][c]) {
                continue
            }
            if (r == m - 1 && c == n - 1) {
                return d
            }
            for (i in 0 until 4) {
                val nr = r + dr[i]
                val nc = c + dc[i]
                if (nr !in 0 until m || nc !in 0 until n) {
                    continue
                }
                val w = grid[nr][nc]
                val nd = d + w
                if (nd < dist[nr][nc]) {
                    dist[nr][nc] = nd
                    if (w == 0) {
                        deque.addFirst(intArrayOf(nr, nc, nd))
                    } else {
                        deque.addLast(intArrayOf(nr, nc, nd))
                    }
                }
            }
        }
        return dist[m - 1][n - 1]
    }
}
package topic.graph

/**
 * 1368. Minimum Cost to Make at Least One Valid Path in a Grid
 * Time: O(m * n)
 * Space: O(m * n)
 */
class MinimumCostMakeLeastOneValidPathGrid {
    fun minCost(grid: Array<IntArray>): Int {
        val dr = listOf(0, 0, 1, -1)
        val dc = listOf(1, -1, 0, 0)
        val m = grid.size
        val n = grid[0].size
        val INF = m * n
        val dist = Array(m) { IntArray(n) { INF } }
        val deque = ArrayDeque<IntArray>()
        deque.addLast(intArrayOf(0, 0, 0))
        dist[0][0] = 0
        while (deque.isNotEmpty()) {
            val (r, c, d) = deque.removeFirst()
            if (r == m - 1 && c == n - 1) {
                return d
            }
            if (d > dist[r][c]) {
                continue
            }
            for (i in 0 until 4) {
                val nr = r + dr[i]
                val nc = c + dc[i]
                if (nr !in 0 until m || nc !in 0 until n) {
                    continue
                }
                val w = if (grid[r][c] == i + 1) 0 else 1
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
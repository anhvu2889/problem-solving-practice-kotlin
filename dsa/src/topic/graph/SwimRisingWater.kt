package topic.graph

import java.util.*

/**
 * 778. Swim in Rising Water
 * Time: O(n * n * log(n))
 * Space: O(n^2)
 */
class SwimRisingWater {
    fun swimInWater(grid: Array<IntArray>): Int {
        val n = grid.size
        val dr = intArrayOf(0, 0, 1, -1)
        val dc = intArrayOf(1, -1, 0, 0)
        val pq = PriorityQueue<IntArray>( compareBy { it[2] })
        val INF = Int.MAX_VALUE
        val dist = Array(n) { IntArray(n) { INF } }

        dist[0][0] = grid[0][0]
        pq.add(intArrayOf(0, 0, dist[0][0]))
        while (pq.isNotEmpty()) {
            val (r, c, d) = pq.poll()
            if (d > dist[r][c]) {
                continue
            }
            if (r == n - 1 && c == n - 1) {
                return d
            }
            for (i in 0 until 4) {
                val nr = r + dr[i]
                val nc = c + dc[i]
                if (nr !in 0 until n || nc !in 0 until n) {
                    continue
                }
                val nd = maxOf(d, grid[nr][nc])
                if (nd < dist[nr][nc]) {
                    dist[nr][nc] = nd
                    pq.add(intArrayOf(nr, nc, nd))
                }
            }
        }
        return -1
    }
}
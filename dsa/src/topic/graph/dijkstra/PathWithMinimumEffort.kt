package topic.graph.dijkstra

import java.util.*
import kotlin.math.abs

/**
 * 1631. Path With Minimum Effort
 * Time: O(m * n * log(v))
 * Space: O(m * n)
 */
class PathWithMinimumEffort {
    fun minimumEffortPath(heights: Array<IntArray>): Int {
        val rows = heights.size
        val cols = heights[0].size
        val dr = intArrayOf(0, 0, 1, -1)
        val dc = intArrayOf(1, -1, 0, 0)
        val INF = Int.MAX_VALUE
        val cost = Array(rows) { IntArray(cols) { INF } }
        val heap = PriorityQueue<IntArray>(Comparator { a, b -> a[2] - b[2] })
        cost[0][0] = 0
        heap.add(intArrayOf(0, 0, 0))
        while (heap.isNotEmpty()) {
            val cur = heap.poll()
            val r = cur[0]
            val c = cur[1]
            val cCost = cur[2]
            if (cCost > cost[r][c]) {
                continue
            }
            for (i in 0 until 4) {
                val nr = r + dr[i]
                val nc = c + dc[i]
                if (nr !in 0 until rows || nc !in 0 until cols) {
                    continue
                }
                val diff = abs(heights[r][c] - heights[nr][nc])
                val nCost = maxOf(diff, cCost)
                if (nCost < cost[nr][nc]) {
                    cost[nr][nc] = nCost
                    heap.add(intArrayOf(nr, nc, nCost))
                }
            }
        }
        return cost[rows - 1][cols - 1]
    }
}
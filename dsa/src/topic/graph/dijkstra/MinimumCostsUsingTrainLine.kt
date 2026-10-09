package topic.graph.dijkstra

import java.util.*

class MinimumCostsUsingTrainLine {
    fun minimumCosts(regular: IntArray, express: IntArray, expressCost: Int): LongArray {
        val n = regular.size
        val INF = Long.MAX_VALUE
        val dist = Array(2) { LongArray(n + 1) { INF } }
        val heap = PriorityQueue<Pair<Long, Pair<Int, Int>>>(compareBy { it.first })
        val dr = intArrayOf(-1, 0, 1)
        val dc = intArrayOf(0, 1, 0)
        heap.add(Pair(0L, Pair(0, 0)))
        dist[0][0] = 0L
        while (heap.isNotEmpty()) {
            val node = heap.poll()
            val currentDist = node.first
            val r = node.second.first
            val c = node.second.second
            for (i in 0 until 3) {
                val nr = r + dr[i]
                val nc = c + dc[i]
                if (nr !in 0 until 2 || nc !in 0..n) {
                    continue
                }
                val w = if (nr < r) 0 else if (nr > r) expressCost else if (r == 0) regular[c] else express[c]
                if (dist[nr][nc] > currentDist + w) {
                    dist[nr][nc] = currentDist + w
                    heap.add(Pair(dist[nr][nc], Pair(nr, nc)))
                }
            }
        }
        val ans = LongArray(n)
        for (i in ans.indices) {
            ans[i] = minOf(dist[0][i + 1], dist[1][i + 1])
        }
        return ans
    }
}
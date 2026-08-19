package topic.graph

import java.util.*

/**
 * 743. Network Delay Time
 * Time:
 * Space:
 */
class NetworkDelayTime {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        val adjEdges = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
        for (time in times) {
            val u = time[0]
            val v = time[1]
            val w = time[2]
            adjEdges[u].add(Pair(v, w))
        }
        val dist = IntArray(n + 1) { Int.MAX_VALUE }
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        pq.add(Pair(k, 0))
        dist[k] = 0
        while (pq.isNotEmpty()) {
            val cur = pq.poll()
            val u = cur.first
            val du = cur.second
            if (du > dist[u])
                continue
            for (adjEdge in adjEdges[u]) {
                val v = adjEdge.first
                val dv = adjEdge.second
                if (du + dv < dist[v]) {
                    dist[v] = du + dv
                    pq.add(Pair(v, dist[v]))
                }
            }
        }
        var ans = 0
        for (i in 1..n) {
            if (dist[i] == Int.MAX_VALUE)
                return -1
            ans = maxOf(ans, dist[i])
        }
        return ans
    }
}
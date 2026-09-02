package topic.graph.bellmanford

/**
 * 787. Cheapest Flights Within K Stops
 * Time: O(k * E)
 * Space: O(V)
 */
class CheapestFlightsWithinKStops {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        val INF = Int.MAX_VALUE
        var prevDist = IntArray(n) { INF }
        prevDist[src] = 0
        repeat(k + 1) {
            val curDist = prevDist.copyOf()
            for ((u, v, w) in flights) {
                if (prevDist[u] == INF) {
                    continue
                }
                val newDist = prevDist[u] + w
                if (newDist < curDist[v]) {
                    curDist[v] = newDist
                }
            }
            prevDist = curDist
        }
        return if (prevDist[dst] == INF) -1 else prevDist[dst]
    }
}
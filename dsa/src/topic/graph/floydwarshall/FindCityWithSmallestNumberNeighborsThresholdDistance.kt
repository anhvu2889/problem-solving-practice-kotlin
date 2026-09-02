package topic.graph.floydwarshall

/**
 * 1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance
 * Time: O(n ^ 3)
 * Space: O(n ^ 2)
 */
class FindCityWithSmallestNumberNeighborsThresholdDistance {
    private val INF = Int.MAX_VALUE

    fun findTheCity(n: Int, edges: Array<IntArray>, distanceThreshold: Int): Int {
        val dist = buildDist(n, edges)
        floydWarshall(dist)
        var min = INF
        var maxIndex = 0
        for (u in 0 until n) {
            val count = countReachable(dist, u, distanceThreshold)
            if (count <= min) {
                min = count
                maxIndex = u
            }
        }
        return maxIndex
    }

    private fun buildDist(n: Int, edges: Array<IntArray>): Array<IntArray> {
        val dist = Array(n) { IntArray(n) { INF } }
        for (i in 0 until n) {
            dist[i][i] = 0
        }
        for ((u, v, w) in edges) {
            dist[u][v] = minOf(dist[u][v], w)
            dist[v][u] = minOf(dist[v][u], w)
        }
        return dist
    }

    private fun floydWarshall(dist: Array<IntArray>) {
        val n = dist.size
        for (i in 0 until n) {
            for (u in 0 until n) {
                if (dist[u][i] == INF) {
                    continue
                }
                for (v in 0 until n) {
                    if (dist[i][v] == INF) {
                        continue
                    }
                    if (dist[u][i] + dist[i][v] < dist[u][v]) {
                        dist[u][v] = dist[u][i] + dist[i][v]
                    }
                }
            }
        }
    }

    private fun countReachable(dist: Array<IntArray>, u: Int, threshold: Int): Int  {
        val n = dist.size
        var count = 0
        for (v in 0 until n) {
            if (u != v && dist[u][v] <= threshold) {
                count++
            }
        }
        return count
    }
}
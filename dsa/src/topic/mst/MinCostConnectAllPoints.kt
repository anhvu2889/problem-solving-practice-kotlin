package topic.mst

import kotlin.math.abs

/**
 * 1584. Min Cost to Connect All Points
 * Time: O(n ^ 2)
 * Space: O(n)
 */
class MinCostConnectAllPoints {
    fun minCostConnectPoints(points: Array<IntArray>): Int {
        val n = points.size
        val minDist = IntArray(n) { Int.MAX_VALUE }
        val inTree = BooleanArray(n)
        minDist[0] = 0
        var minCost = 0
        repeat(n) {
            var u = -1
            for (v in 0 until n) {
                if (!inTree[v] && (u == -1 || minDist[v] < minDist[u])) {
                    u = v
                }
            }

            inTree[u] = true
            minCost += minDist[u]

            for (v in 0 until n) {
                if (!inTree[v]) {
                    val d = abs(points[u][0] - points[v][0]) + abs(points[u][1] - points[v][1])
                    if (d < minDist[v]) {
                        minDist[v] = d
                    }
                }
            }
        }
        return minCost
    }
}
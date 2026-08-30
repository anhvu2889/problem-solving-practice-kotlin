package topic.mst


/**
 * 1135. Connecting Cities With Minimum Cost
 * Time: O(E * log(E))
 * Space: O(V + E)
 */
class ConnectingCitiesWithMinimumCost {
    fun minimumCost(n: Int, connections: Array<IntArray>): Int {
        connections.sortBy { it[2] }
        val parent = IntArray(n + 1) { it }
        val size = IntArray(n + 1) { 1 }
        var cost = 0
        var component = n
        for ((a, b, w) in connections) {
            if (!union(a, b, parent, size)) {
                continue
            }
            cost += w
            component--
            if (component == 1) {
                return cost
            }
        }
        return -1
    }

    private fun find (x: Int, parent: IntArray): Int {
        var root = x
        while (parent[root] != root) {
            root = parent[root]
        }
        var cur = x
        while (cur != root) {
            val temp = parent[cur]
            parent[cur] = root
            cur = temp
        }
        return root
    }

    private fun union(a: Int, b: Int, parent: IntArray, size: IntArray): Boolean {
        var ra = find(a, parent)
        var rb = find(b, parent)
        if (ra == rb) {
            return false
        }
        if (size[ra] < size[rb]) {
            val temp = ra
            ra = rb
            rb = temp
        }
        parent[rb] = ra
        size[ra] += size[rb]
        return true
    }
}
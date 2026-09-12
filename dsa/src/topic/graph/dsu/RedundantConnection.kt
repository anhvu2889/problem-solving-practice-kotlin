package topic.graph.dsu

/**
 * 684. Redundant Connection
 * Time: O(n * alpha(n))
 * SpacE: O(n)
 */
class RedundantConnection {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val n = edges.size
        val parent = IntArray(n + 1) { it }
        val size = IntArray(n + 1) { 1 }
        for (edge in edges) {
            val a = edge[0]
            val b = edge[1]
            if (!union(a, b, parent, size)) {
                return edge
            }
        }
        return intArrayOf(0, 0)
    }

    private fun find(x: Int, parent: IntArray): Int {
        var root = x
        while (parent[root] != root) {
            root = parent[root]
        }
        var cur = x
        while (parent[cur] != root) {
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
        if (size[rb] > size[ra]) {
            val temp = ra
            ra = rb
            rb = temp
        }
        parent[rb] = ra
        size[ra] += size[rb]
        return true
    }
}
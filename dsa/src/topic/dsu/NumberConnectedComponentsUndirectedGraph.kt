package topic.dsu

/**
 * 323. Number of Connected Components in an Undirected Graph
 * Time: O(V + E)
 * Space: O(V)
 */
class NumberConnectedComponentsUndirectedGraph {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val parent = IntArray(n) { it }
        val size = IntArray(n) { 1 }
        var count = n
        for ((a, b) in edges) {
            if (union(a, b, parent, size)) {
                count--
            }
        }
        return count
    }

    private fun find (x: Int, parent: IntArray): Int {
        var root = x
        while (parent[root] != root) {
            root = parent[root]
        }
        var cur = x
        while (parent[cur] != root) {
            val temp = parent[cur]
            parent[cur] = root
            cur = parent[cur]
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
package topic.dsu

/**
 * 1101. The Earliest Moment When Everyone Become Friends
 * Time: O(E * log(E) + E * alpha(V))
 * Space: O(V + E)
 */
class TheEarliestMomentWhenEveryoneBecomeFriends {
    fun earliestAcq(logs: Array<IntArray>, n: Int): Int {
        logs.sortBy { it[0] }
        val parent = IntArray(n) { it }
        val size = IntArray(n) { 1 }
        var disconnected = n
        for (log in logs) {
            val a = log[1]
            val b = log[2]
            if (union(a, b, parent, size)) {
                disconnected--
            }
            if (disconnected == 1) {
                return log[0]
            }
        }
        return -1
    }

    private fun find(x: Int, parent: IntArray): Int {
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
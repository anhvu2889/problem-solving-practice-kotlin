package topic.graph

/**
 * 305. Number of Islands II
 * Time: O(k * alpha(m * n)
 * Space: O(m * n)
 */
class NumberIslandsII {
    fun numIslands2(m: Int, n: Int, positions: Array<IntArray>): List<Int> {
        val parent = IntArray(m * n) { -1 }
        val size = IntArray(m * n)
        val ans = mutableListOf<Int>()
        var count = 0
        val dr = listOf(0, 0, 1, -1)
        var dc = listOf(-1, 1, 0, 0)
        for (pos in positions) {
            val r = pos[0]
            val c = pos[1]
            val id = r * n + c
            if (parent[id] != -1) {
                ans.add(count)
                continue
            }
            parent[id] = id
            size[id] = 1
            count++
            for (i in 0 until 4) {
                val nr = r + dr[i]
                val nc = c + dc[i]
                if (nr !in 0 until m || nc !in 0 until n) {
                    continue
                }
                val nb = nr * n + nc
                if (parent[nb] != -1 && union(id, nb, parent, size)) {
                    count--
                }
            }
            ans.add(count)
        }
        return ans
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
        if (size[rb] > size[ra]) {
            val temp = rb
            rb = ra
            ra = temp
        }
        size[ra] += size[rb]
        parent[rb] = ra
        return true
    }
}
package topic.graph

/**
 * 2685. Count the Number of Complete Components
 * Time: O(V + E)
 * Space: O(V + E)
 */
class CountNumberCompleteComponents {
    fun countCompleteComponents(n: Int, edges: Array<IntArray>): Int {
        var ans = 0
        val adjEdges = Array(n) { mutableListOf<Int>() }
        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]
            adjEdges[u].add(v)
            adjEdges[v].add(u)
        }
        val visited = BooleanArray(n)
        for (i in 0 until n) {
            if (visited[i])
                continue
            val queue = ArrayDeque<Int>()
            queue.addFirst(i)
            visited[i] = true
            var levelSum = 0
            var verCount = 0
            while (queue.isNotEmpty()) {
                val src = queue.removeLast()
                levelSum += adjEdges[src].size
                verCount += 1
                for (adj in adjEdges[src]) {
                    if (visited[adj])
                        continue
                    queue.addFirst(adj)
                    visited[adj] = true
                }
            }
            if (verCount * (verCount - 1) / 2 == levelSum / 2)
                ans++
        }
        return ans
    }
}
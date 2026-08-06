package topic.graph

/**
 * 3310. Remove Methods From Project
 * Time: O(V + E)
 * Space: O(V + E)
 */
class RemoveMethodsFromProject {
    fun remainingMethods(n: Int, k: Int, invocations: Array<IntArray>): List<Int> {
        val adjEdges = Array(n) { mutableListOf<Int>() }
        for (invocation in invocations) {
            adjEdges[invocation[0]].add(invocation[1])
        }
        val visited = BooleanArray(n)
        visited[k] = true
        val queue = ArrayDeque<Int>()
        queue.addFirst(k)
        while (queue.isNotEmpty()) {
            val cur = queue.removeLast()
            for (adjNode in adjEdges[cur]) {
                if (visited[adjNode])
                    continue
                visited[adjNode] = true
                queue.addFirst(adjNode)
            }
        }
        for (invocation in invocations) {
            if (!visited[invocation[0]] && visited[invocation[1]])
                return (0 until n).toList()
        }
        val ans = mutableListOf<Int>()
        for (i in visited.indices) {
            if (!visited[i])
                ans.add(i)
        }
        return ans
    }
}
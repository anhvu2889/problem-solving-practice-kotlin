package topic.graph.topologicalsort

/**
 * 1059. All Paths from Source Lead to Destination
 * Time: O(V + E)
 * Space: O(V + E)
 */
class AllPathsFromSourceLeadToDestination {
    private val TODO = 0
    private val ON_PATH = 1
    private val DONE = 2
    fun leadsToDestination(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        val graph = buildGraph(n, edges)
        if (graph[destination].isNotEmpty()) {
            return false
        }
        val state = IntArray(n) { TODO }
        return dfs(source, destination, graph, state)
    }

    private fun buildGraph(n: Int, edges: Array<IntArray>): Array<HashSet<Int>> {
        val graph = Array(n) { HashSet<Int>() }
        for ((u, v) in edges) {
            graph[u].add(v)
        }
        return graph
    }

    private fun dfs(cur: Int, des: Int, graph: Array<HashSet<Int>>, state: IntArray): Boolean {
        if (graph[cur].isEmpty()) {
            return cur == des
        }
        state[cur] = ON_PATH
        for (nb in graph[cur]) {
            if (state[nb] == ON_PATH) {
                return false
            }
            if (state[nb] != DONE && !dfs(nb, des, graph, state)) {
                return false
            }
        }
        state[cur] = DONE
        return true
    }
}
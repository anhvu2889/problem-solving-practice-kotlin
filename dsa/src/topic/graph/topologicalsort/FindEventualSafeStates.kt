package topic.graph.topologicalsort

/**
 * 802. Find Eventual Safe States
 * Time: O(V + E)
 * Space: O(V + E)
 */
class FindEventualSafeStates {
    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        val rev = reverseGraph(graph)
        val outdeg = outdegree(graph)
        val queue = ArrayDeque<Int>()
        val ans = mutableListOf<Int>()
        for (i in outdeg.indices) {
            if (outdeg[i] == 0) {
                queue.addLast(i)
            }
        }
        while (queue.isNotEmpty()) {
            val cur = queue.removeFirst()
            val adjNodes = rev[cur]
            for (node in adjNodes) {
                outdeg[node]--
                if (outdeg[node] == 0) {
                    queue.addLast(node)
                }
            }
        }
        for (i in outdeg.indices) {
            if (outdeg[i] == 0) {
                ans.add(i)
            }
        }
        return ans
    }

    private fun reverseGraph(graph: Array<IntArray>): Array<MutableList<Int>> {
        val n = graph.size
        val rev = Array(n) { mutableListOf<Int>() }
        for (src in graph.indices) {
            val adjNodes = graph[src]
            for (node in adjNodes) {
                rev[node].add(src)
            }
        }
        return rev
    }

    private fun outdegree(graph: Array<IntArray>): IntArray {
        val outdeg = IntArray(graph.size)
        for (i in graph.indices) {
            outdeg[i] = graph[i].size
        }
        return outdeg
    }
}
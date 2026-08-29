package top150.graph

/**
 * 207. Course Schedule
 * Time: O(V + E)
 * Space: O(V + E)
 */
class CourseSchedule {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val graph = buildGraph(numCourses, prerequisites)
        val indeg = buildInDegree(numCourses, prerequisites)
        return kahn(graph, indeg)
    }

    private fun buildGraph(numCourses: Int, prerequisites: Array<IntArray>): Array<MutableList<Int>> {
        val graph = Array(numCourses) { mutableListOf<Int>() }
        for (p in prerequisites) {
            val a = p[0]
            val b = p[1]
            graph[b].add(a)
        }
        return graph
    }

    private fun buildInDegree(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val indeg = IntArray(numCourses)
        for (p in prerequisites) {
            val i = p[0]
            indeg[i]++
        }
        return indeg
    }

    private fun kahn(graph: Array<MutableList<Int>>, indeg: IntArray): Boolean {
        val queue = ArrayDeque<Int>()
        for (i in indeg.indices) {
            if (indeg[i] == 0) {
                queue.addLast(i)
            }
        }
        var taken = 0
        while (queue.isNotEmpty()) {
            val cur = queue.removeFirst()
            taken++
            val neighbors = graph[cur]
            for (nb in neighbors) {
                indeg[nb]--
                if (indeg[nb] == 0) {
                    queue.addLast(nb)
                }
            }
        }
        return taken == graph.size
    }
}
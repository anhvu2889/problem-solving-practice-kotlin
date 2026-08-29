package top150.graph

/**
 * 210. Course Schedule II
 * Time: O(V + E)
 * Space: O(V + E)
 */
class CourseScheduleII {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val graph = buildGraph(numCourses, prerequisites)
        val indeg = buildIndegree(numCourses, prerequisites)
        return kahn(graph, indeg)
    }

    private fun buildGraph(numCourses: Int, prerequisites: Array<IntArray>): Array<MutableList<Int>> {
        val graph = Array(numCourses) { mutableListOf<Int>() }
        for ((a, b) in prerequisites) {
            graph[b].add(a)
        }
        return graph
    }

    private fun buildIndegree(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val indeg = IntArray(numCourses)
        for ((a, _) in prerequisites) {
            indeg[a]++
        }
        return indeg
    }

    private fun kahn(graph: Array<MutableList<Int>>, indeg: IntArray): IntArray {
        val order = IntArray(indeg.size)
        val queue = ArrayDeque<Int>()
        var index = 0
        for (i in indeg.indices) {
            if (indeg[i] == 0) {
                queue.addLast(i)
            }
        }
        while (queue.isNotEmpty()) {
            val cur = queue.removeFirst()
            order[index] = cur
            index++
            val neighbors = graph[cur]
            for (nb in neighbors) {
                indeg[nb]--
                if (indeg[nb] == 0) {
                    queue.addLast(nb)
                }
            }
        }
        return if (index == graph.size) order else intArrayOf()
    }
}
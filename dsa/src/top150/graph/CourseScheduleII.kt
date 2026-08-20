package top150.graph

/**
 * 210. Course Schedule II
 * Time: O(V + E)
 * Space: O(V + E)
 */
class CourseScheduleII {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val indegree = IntArray(numCourses)
        val adjVertices = Array(numCourses) { mutableListOf<Int>() }
        for (pre in prerequisites) {
            val a = pre[0]
            val b = pre[1]
            adjVertices[b].add(a)
            indegree[a]++
        }
        val queue = ArrayDeque<Int>()
        for (i in indegree.indices) {
            if (indegree[i] == 0) {
                queue.addFirst(i)
            }
        }
        var index = 0
        val order = IntArray(numCourses)
        while (queue.isNotEmpty()) {
            val cur = queue.removeLast()
            order[index] = cur
            index++
            for (adj in adjVertices[cur]) {
                indegree[adj]--
                if (indegree[adj] == 0)
                    queue.addFirst(adj)
            }
        }
        return if (index == numCourses) order else intArrayOf()
    }
}
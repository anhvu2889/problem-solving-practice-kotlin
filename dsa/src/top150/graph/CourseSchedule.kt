package top150.graph

/**
 * 207. Course Schedule
 * Time: O(V + E)
 * Space: O(V + E)
 */
class CourseSchedule {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val adjNodes = Array(numCourses) { mutableListOf<Int>() }
        val indegree = IntArray(numCourses)
        for (pre in prerequisites) {
            val a = pre[0]
            val b = pre[1]
            adjNodes[b].add(a)
            indegree[a]++
        }
        val queue = ArrayDeque<Int>()
        for (i in indegree.indices) {
            if (indegree[i] == 0)
                queue.addFirst(i)
        }
        var count = 0
        while (queue.isNotEmpty()) {
            val cur = queue.removeLast()
            count++
            for (adj in adjNodes[cur]) {
                indegree[adj]--
                if (indegree[adj] == 0)
                    queue.addFirst(adj)
            }
        }
        return count == numCourses
    }
}
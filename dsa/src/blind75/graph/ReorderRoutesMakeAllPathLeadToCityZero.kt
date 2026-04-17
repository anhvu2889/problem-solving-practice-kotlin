package blind75.graph

/**
 * 1466. Reorder Routes to Make All Paths Lead to the City Zero
 * Time: O(V + E)
 * Space: O(V)
 */
class ReorderRoutesMakeAllPathLeadToCityZero {
    fun minReorder(n: Int, connections: Array<IntArray>): Int {
        val adjList = Array(n) { mutableListOf<IntArray>() }
        for (edge in connections) {
            adjList[edge[0]].add(intArrayOf(edge[1], 1))
            adjList[edge[1]].add(intArrayOf(edge[0], 0))
        }
        val visit = BooleanArray(n)
        return dfs(0, visit, adjList)
    }

    fun dfs(start: Int, visit: BooleanArray, adjList: Array<MutableList<IntArray>>): Int {
        var changes = 0
        val stack = ArrayDeque<Int>()
        visit[start] = true
        stack.addLast(start)
        while (stack.isNotEmpty()) {
            val cur = stack.removeLast()
            for (edge in adjList[cur]) {
                val next = edge[0]
                val needFlip = edge[1]
                if (!visit[next]) {
                    visit[next] = true
                    changes += needFlip
                    stack.addLast(next)
                }
            }
        }
        return changes
    }
}
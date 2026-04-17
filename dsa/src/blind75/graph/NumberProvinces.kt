package blind75.graph

/**
 * 547. Number of Provinces
 * Time: O( n^2)
 * Space: O(n)
 */
class NumberProvinces {
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val n = isConnected.size
        val visit = BooleanArray(n)
        var count = 0
        for (city in isConnected.indices) {
            if (!visit[city]) {
                visit[city]
                dfs(city, isConnected, visit)
                count++
            }
        }
        return count
    }

    fun dfs(city: Int, adjMatrix: Array<IntArray>, visit: BooleanArray) {
        val stack = ArrayDeque<Int>()
        stack.addLast(city)
        while (stack.isNotEmpty()) {
            val current = stack.removeLast()
            for (next in adjMatrix.indices) {
                if (!visit[next] && adjMatrix[current][next] == 1) {
                    visit[next] = true
                    stack.addLast(next)
                }
            }
        }
    }
}
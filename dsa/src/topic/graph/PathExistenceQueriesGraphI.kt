package topic.graph

/**
 * 3532. Path Existence Queries in a Graph I
 * Time: O(n + m)
 * Space: O(n)
 */
class PathExistenceQueriesGraphI {
    fun pathExistenceQueries(n: Int, nums: IntArray, maxDiff: Int, queries: Array<IntArray>): BooleanArray {
        val ans = BooleanArray(queries.size)
        val comp = IntArray(n)
        for (i in 1 until n) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                comp[i] = comp[i - 1] + 1
            } else {
                comp[i] = comp[i - 1]
            }
        }
        for (i in queries.indices) {
            val u = queries[i][0]
            val v = queries[i][1]
            if (comp[u] == comp[v])
                ans[i] = true
        }
        return ans
    }
}
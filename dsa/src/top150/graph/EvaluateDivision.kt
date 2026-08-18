package top150.graph

/**
 * 399. Evaluate Division
 * Time:
 * Space:
 */
class EvaluateDivision {
    private val parent = HashMap<String, String>()
    private val weight = HashMap<String, Double>()
    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        val ans = DoubleArray(queries.size)
        for (i in equations.indices) {
            val equation = equations[i]
            val x = equation[0]
            val y = equation[1]
            val value = values[i]
            union(x, y, value)
        }

        for (i in queries.indices) {
            val x = queries[i][0]
            val y = queries[i][1]
            if (x !in parent || y !in parent || find(x) != find(y))
                ans[i] = -1.0
            else
                ans[i] = weight[x]!! / weight[y]!!
        }

        return ans
    }

    private fun find(x: String): String {
        if (x !in parent) {
            parent[x] = x
            weight[x] = 1.0
        }
        val p = parent[x]!!
        if (p == x)
            return x
        val root = find(p)
        weight[x] = weight[x]!! * weight[p]!!
        parent[x] = root
        return root
    }

    private fun union(x: String, y: String, value: Double) {
        val rootX = find(x)
        val rootY = find(y)
        if (rootX != rootY) {
            parent[rootX] = rootY
            weight[rootX] = weight[y]!! / weight[x]!! * value
        }
    }
}
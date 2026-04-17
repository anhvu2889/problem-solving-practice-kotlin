package blind75.graph

class EvaluateDivisionDSU {

    private val parent = HashMap<String, String>()
    private val weight = HashMap<String, Double>()
    fun calcEquation(
        equations: List<List<String>>,
        values: DoubleArray,
        queries: List<List<String>>
    ): DoubleArray {
        for (i in equations.indices) {
            val a = equations[i][0]
            val b = equations[i][1]
            union(a, b, values[i])
        }
        val result = DoubleArray(queries.size)
        for (i in queries.indices) {
            val a = queries[i][0]
            val b = queries[i][1]
            if (!parent.containsKey(a) || !parent.containsKey(b)) {
                result[i] = -1.0
                continue
            }
            val rootA = find(a)
            val rootB = find(b)
            if (rootA == rootB) {
                result[i] = weight[a]!! / weight[b]!!
            } else {
                result[i] = -1.0
            }
        }
        return result
    }

    fun find(x: String): String {
        val parentX = parent[x]!!
        if (parentX != x) {
            val root = find(parentX)
            weight[x] = weight[x]!! * weight[parentX]!!
            parent[x] = root
        }
        return parent[x]!!
    }

    fun add(x: String) {
        if (!parent.containsKey(x)) {
            parent[x] = x
            weight[x] = 1.0
        }
    }

    fun union(a: String, b: String, value: Double) {
        add(a)
        add(b)
        val rootA = find(a)
        val rootB = find(b)
        if (rootA == rootB)
            return
        parent[rootA] = rootB
        weight[rootA] = value * weight[b]!! / weight[a]!!
    }

}
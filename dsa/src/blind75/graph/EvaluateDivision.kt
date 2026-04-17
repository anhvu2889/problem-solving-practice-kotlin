package blind75.graph

/**
 * 399. Evaluate Division
 * Time: O( Q * (V + E))
 * Space: O(V + E)
 */
class EvaluateDivision {
    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        val graph = HashMap<String, MutableList<Edge>>()
        for (i in values.indices) {
            val equation = equations[i]
            val from = equation[0]
            val to = equation[1]
            graph.computeIfAbsent(from) { mutableListOf<Edge>() }.add(Edge(to, values[i]))
            graph.computeIfAbsent(to) { mutableListOf<Edge>() }.add(Edge(from, 1.0 / values[i]))
        }
        val result = DoubleArray(queries.size)
        for (i in queries.indices) {
            val query = queries[i]
            val from = query[0]
            val to = query[1]
            if (!graph.containsKey(from) || !graph.containsKey(to)) {
                result[i] = -1.0
            } else if (from == to) {
                result[i] = 1.0
            } else {
                result[i] = dfs(from, to, graph)
            }
        }
        return result
    }

    fun dfs(start: String, dest: String, graph: HashMap<String, MutableList<Edge>>): Double {
        val visited = HashSet<String>()
        val stack = ArrayDeque<Path>()
        stack.addLast(Path(start, 1.0))
        visited.add(start)
        while (stack.isNotEmpty()) {
            val currentPath = stack.removeLast()
            if (currentPath.node == dest) {
                return currentPath.cost
            }
            val adjEdges = graph.getOrDefault(currentPath.node, mutableListOf())
            for (edge in adjEdges) {
                if (!visited.contains(edge.dest)) {
                    stack.addLast(Path(edge.dest, currentPath.cost * edge.weight))
                    visited.add(edge.dest)
                }
            }
        }
        return -1.0
    }

    class Edge(val dest: String, val weight: Double)

    class Path(val node: String, val cost: Double)
}
package topic.tree

/**
 * 834. Sum of Distances in Tree
 * Time: O(n)
 * Space: O(n)
 */
class SumDistancesTree {
    fun sumOfDistancesInTree(n: Int, edges: Array<IntArray>): IntArray {
        val graph = buildGraph(n, edges)
        val subTreeSize = IntArray(n) { 1 }
        val distInSubTree = IntArray(n)
        val parent = IntArray(n)
        val order = bfs(graph, parent)
        fillBottomUp(n, order, parent, subTreeSize, distInSubTree)
        return fillTopDown(n, order, parent, subTreeSize, distInSubTree)
    }

    private fun buildGraph(n: Int, edges: Array<IntArray>): Array<MutableList<Int>> {
        val graph = Array(n) { mutableListOf<Int>() }
        for ((u, v) in edges) {
            graph[u].add(v)
            graph[v].add(u)
        }
        return graph
    }

    private fun bfs(graph: Array<MutableList<Int>>, parent: IntArray): IntArray {
        val order = IntArray(graph.size)
        val queue = ArrayDeque<Int>()
        var index = 0
        queue.addLast(0)
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            order[index] = node
            index++
            for (next in graph[node]) {
                if (next != parent[node]) {
                    parent[next] = node
                    queue.addLast(next)
                }
            }
        }
        return order
    }

    private fun fillBottomUp(
        n: Int,
        order: IntArray,
        parent: IntArray,
        subTreeSize: IntArray,
        distInSubTree: IntArray
    ) {
        for (i in n - 1 downTo 0) {
            val child = order[i]
            if (child == 0) {
                continue
            }
            val p = parent[child]
            subTreeSize[p] += subTreeSize[child]
            distInSubTree[p] += distInSubTree[child] + subTreeSize[child]
        }
    }

    private fun fillTopDown(
        n: Int,
        order: IntArray,
        parent: IntArray,
        subtreeSize: IntArray,
        distInSubtree: IntArray
    ): IntArray {
        val distSum = IntArray(n)
        distSum[0] = distInSubtree[0]
        for (child in order) {
            if (child == 0) continue
            val p = parent[child]
            distSum[child] = distSum[p] + n - 2 * subtreeSize[child]
        }
        return distSum
    }
}
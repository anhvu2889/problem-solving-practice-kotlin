package top150.graph

/**
 * 133. Clone Graph
 * Time: O()
 * Space:
 */
class CloneGraph {

    class Node(var `val`: Int) {
        var neighbors: ArrayList<Node?> = ArrayList<Node?>()
    }

    fun cloneGraph(node: Node?): Node? {
        if (node == null)
            return null
        val cloneMap = HashMap<Node, Node>()
        val stack = ArrayDeque<Node>()
        cloneMap[node] = Node(node.`val`)
        stack.addLast(node)
        while (stack.isNotEmpty()) {
            val cur = stack.removeLast()
            val curClone = cloneMap[cur]
            for (neighbor in cur.neighbors) {
                if (neighbor == null)
                    continue
                var neighborClone = cloneMap[neighbor]
                if (neighborClone == null) {
                    neighborClone = Node(neighbor.`val`)
                    cloneMap[neighbor] = neighborClone
                    stack.addLast(neighbor)
                }
                curClone?.neighbors?.add(neighborClone)
            }
        }
        return cloneMap[node]
    }
}
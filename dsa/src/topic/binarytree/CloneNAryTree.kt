package topic.binarytree

/**
 * 1490. Clone N-ary Tree
 * Time: O(n)
 * Space: O(n)
 */
class CloneNAryTree {
    class Node(var `val`: Int) {
        var children: List<Node?> = listOf()
    }

    fun cloneTree(root: Node?): Node? {
        val map = HashMap<Node, Node>()
        return copyNode(root, map)
    }

    private fun copyNode(src: Node?, map: HashMap<Node, Node>): Node? {
        if (src == null)
            return null
        map[src]?.let { return it }
        val copy = Node(src.`val`)
        val copyChilds = ArrayList<Node>()
        for (child in src.children) {
            val copyChild = copyNode(child, map)
            copyChilds.add(copyChild!!)
        }
        copy.children = copyChilds
        map[src] = copy
        return copy
    }
}
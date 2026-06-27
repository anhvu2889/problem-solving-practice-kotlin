package topic.linkedlist

/**
 * 1485. Clone Binary Tree With Random Pointer
 * Time: O(n)
 * Space: O(n)
 */
class CloneBinaryTreeWithRandomPointer {
    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
        var random: Node? = null
    }

    class NodeCopy(var `val`: Int) {
        var left: NodeCopy? = null
        var right: NodeCopy? = null
        var random: NodeCopy? = null
    }

    fun copyRandomBinaryTree(root: Node?): NodeCopy? {
        val map = HashMap<Node, NodeCopy>()
        return copy(root, map)
    }

    fun copy(src: Node?, map: HashMap<Node, NodeCopy>): NodeCopy? {
        if (src == null)
            return null
        map[src]?.let { return it }
        val copy = NodeCopy(src.`val`)
        map[src] = copy
        copy.left = copy(src.left, map)
        copy.right = copy(src.right, map)
        copy.random = copy(src.random, map)
        return copy
    }
}
package topic.tree

import blind75.binarytree.TreeNode

class CousinsBinaryTree {
    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
        if (root == null) {
            return false
        }
        val queue = ArrayDeque<TreeNode>()
        queue.addLast(root)
        while (queue.isNotEmpty()) {
            var foundX = false
            var foundY = false
            val size = queue.size
            repeat(size) {
                val node = queue.removeFirst()
                if (node.`val` == x) {
                    foundX = true
                }
                if (node.`val` == y) {
                    foundY = true
                }
                if (isSibling(node, x, y)) {
                    return false
                }
                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }
            if (foundX && foundY) {
                return true
            }
            if (foundX || foundY) {
                return false
            }
        }
        return false
    }

    private fun isSibling(node: TreeNode, x: Int, y: Int): Boolean {
        val l = node.left?.`val`
        val r = node.right?.`val`
        return (l == x && r == y) || (l == y && r == x)
    }
}
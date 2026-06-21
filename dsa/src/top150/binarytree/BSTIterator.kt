package top150.binarytree

import blind75.binarytree.TreeNode

/**
 * 173. Binary Search Tree Iterator
 * Time: O(1)
 * Space: O(h)
 */
class BSTIterator(root: TreeNode?) {

    private lateinit var stack: ArrayDeque<TreeNode>

    init{
        stack = ArrayDeque()
        pushLeft(root)
    }

    private fun pushLeft(node: TreeNode?) {
        var cur = node
        while (cur != null) {
            stack.addLast(cur)
            cur = cur.left
        }
    }

    fun next(): Int {
        val node = stack.removeLast()
        pushLeft(node.right)
        return node.`val`
    }

    fun hasNext(): Boolean {
        return stack.isNotEmpty()
    }

}
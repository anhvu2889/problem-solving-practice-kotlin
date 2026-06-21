package top150.binarytree

import blind75.binarytree.TreeNode

/**
 * 226. Invert Binary Tree
 * Time:
 * Space:
 */
class InvertBinaryTree {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null)
            return root
        val queue = ArrayDeque<TreeNode>()
        queue.addLast(root)
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            val left = node.left
            node.left = node.right
            node.right = left
            node.left?.let { queue.addLast(it) }
            node.right?.let { queue.addLast(it) }
        }
        return root
    }
}
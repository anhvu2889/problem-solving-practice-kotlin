package top150.binarytree

import blind75.binarytree.TreeNode

/**
 * 104. Maximum Depth of Binary Tree
 * Time: O(n)
 * Space: O(w)
 */
class MaximumDepthBinaryTree {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val queue = ArrayDeque<TreeNode>()
        queue.addLast(root)
        var level = 0
        while (queue.isNotEmpty()) {
            val size = queue.size
            level++
            repeat(size) {
                val node = queue.removeFirst()
                node.left?.let { queue.addLast(it) }
                node.right?.let { queue.addLast(it) }
            }
        }
        return level
    }
}
package top150.binarytree

import blind75.binarytree.TreeNode

/**
 * 102. Binary Tree Level Order Traversal
 * Time: O(n)
 * Space: O(w)
 */
class BinaryTreeLevelOrderTraversal {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if (root == null)
            return result
        val queue = ArrayDeque<TreeNode>()
        queue.addLast(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            val list = mutableListOf<Int>()
            repeat(size) {
                val node = queue.removeFirst()
                list.add(node.`val`)
                node.left?.let { queue.addLast(it) }
                node.right?.let { queue.addLast(it) }
            }
            result.add(list)
        }
        return result
    }
}
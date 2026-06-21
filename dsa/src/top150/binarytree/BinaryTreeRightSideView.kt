package top150.binarytree

import blind75.binarytree.TreeNode

/**
 * 199. Binary Tree Right Side View
 * Time: O(n)
 * Space: O(w)
 */
class BinaryTreeRightSideView {
    fun rightSideView(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        if (root == null)
            return result
        val queue = ArrayDeque<TreeNode>()
        queue.addLast(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            result.add(queue.first().`val`)
            repeat(size) {
                val node = queue.removeFirst()
                node.right?.let {queue.add(it)}
                node.left?.let {queue.add(it)}
            }
        }
        return result
    }
}
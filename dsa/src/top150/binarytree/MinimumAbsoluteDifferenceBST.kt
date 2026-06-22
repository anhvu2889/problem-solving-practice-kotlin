package top150.binarytree

import blind75.binarytree.TreeNode

/**
 * 530. Minimum Absolute Difference in BST
 * Time: O(n)
 * Space: O(h)
 */
class MinimumAbsoluteDifferenceBST {
    private var prev = -1
    private var min = Int.MAX_VALUE
    fun getMinimumDifference(root: TreeNode?): Int {
        prev = -1
        min = Int.MAX_VALUE
        inOrder(root)
        return min
    }

    private fun inOrder(node: TreeNode?) {
        if (node == null)
            return

        inOrder(node.left)
        if (prev >= 0)
            min = minOf(min, node.`val` - prev)
        prev = node.`val`
        inOrder(node.right)
    }
}
package top150.binarytree

import blind75.binarytree.TreeNode

/**
 * 124. Binary Tree Maximum Path Sum
 * Time: O(n)
 * Space: O(h)
 */
class BinaryTreeMaximumPathSum {

    private var max = Int.MIN_VALUE

    fun maxPathSum(root: TreeNode?): Int {
        max = Int.MIN_VALUE
        dfs(root)
        return max
    }

    fun dfs(node: TreeNode?): Int {
        if (node == null)
            return 0
        val left = maxOf(dfs(node.left), 0)
        val right = maxOf(dfs(node.right), 0)
        max = maxOf(max, node.`val` + left + right)
        return node.`val` + maxOf(left, right)
    }
}
package top150.binarytree

import blind75.binarytree.TreeNode

/**
 * 112. Path Sum
 * Time: O(n)
 * Space: O(h)
 */
class PathSum {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null)
            return false
        if (root.`val` == targetSum && root.left == null && root.right == null)
            return true
        val leftCheck = hasPathSum(root.left, targetSum - root.`val`)
        val rightCheck = hasPathSum(root.right, targetSum - root.`val`)
        return leftCheck || rightCheck
    }
}
package top150.binarytree

import blind75.binarytree.TreeNode

/**
 * 101. Symmetric Tree
 * Time: O(n)
 * Space: O(h)
 */
class SymmetricTree {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null)
            return true
        return isMirror(root.left, root.right)
    }

    fun isMirror(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null)
            return true
        if (left == null || right == null)
            return false
        return left.`val` == right.`val` && isMirror(left.left, right.right) && isMirror(left.right, right.left)
    }
}
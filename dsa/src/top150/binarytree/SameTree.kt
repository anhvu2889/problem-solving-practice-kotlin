package top150.binarytree

import blind75.binarytree.TreeNode

/**
 * 100. Same Tree
 * Time: O(min(n, m))
 * Space:O(min(h, k)
 */
class SameTree {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null)
            return true
        if (p == null || q == null)
            return false
        if (p.`val` != q.`val`)
            return false
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }
}
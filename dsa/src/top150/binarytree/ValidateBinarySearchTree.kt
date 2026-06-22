package top150.binarytree

import blind75.binarytree.TreeNode

/**
 * 98. Validate Binary Search Tree
 * Time: O(n)
 * Space: O(h)
 */
class ValidateBinarySearchTree {
    private var prev: Int? = null
    private var isValid = true
    fun isValidBST(root: TreeNode?): Boolean {
        prev = null
        isValid = true
        inOrder(root)
        return isValid
    }

    private fun inOrder(node: TreeNode?) {
        if (node == null || !isValid)
            return
        inOrder(node.left)
        prev?.let {
            if (it >= node.`val`) {
                isValid = false
                return
            }

        }
        prev = node.`val`
        inOrder(node.right)
    }
}
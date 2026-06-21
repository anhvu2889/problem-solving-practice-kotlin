package top150.binarytree

import blind75.binarytree.TreeNode

/**
 * 114. Flatten Binary Tree to Linked List
 * Time: O(n)
 * Space: O(1)
 */
class FlattenBinaryTreeLinkedList {
    fun flatten(root: TreeNode?): Unit {
        var cur = root
        while (cur != null) {
            if (cur.left != null) {
                var leftTail = cur.left!!
                while(leftTail.right != null) {
                    leftTail = leftTail.right!!
                }
                leftTail.right = cur.right
                cur.right = cur.left
                cur.left = null
            }
            cur = cur.right
        }
    }

    private fun getFlattenTail(node: TreeNode?): TreeNode? {
        if (node == null)
            return null
        val leftTail = getFlattenTail(node.left)
        val rightTail = getFlattenTail(node.right)
        if (leftTail != null) {
            leftTail.right = node.right
            node.right = node.left
            node.left = null
        }
        return rightTail ?: leftTail ?: node
    }
}
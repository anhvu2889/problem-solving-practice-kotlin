package topic.binarytree

import blind75.binarytree.TreeNode

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * Time: O(h)
 * Space: O(1)
 */
class LowestCommonAncestorBinarySearchTree {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || p == null || q == null) {
            return null
        }
        if (root == p || root == q) {
            return root
        }
        val min = minOf(p.`val`, q.`val`)
        val max = maxOf(p.`val`, q.`val`)
        var node: TreeNode? = root
        while (node != null) {
            if (max < node.`val`) {
                node = node.left
            } else if (min > node.`val`) {
                node = node.right
            } else {
                return node
            }
        }
        return null
    }
}
package topic.binarytree

import blind75.binarytree.TreeNode

/**
 * 938. Range Sum of BST
 * Time: O(n)
 * Space: O(h)
 */
class RangeSumBST {
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        if (root == null) {
            return 0
        }
        if (root.`val` < low) {
            return rangeSumBST(root.right, low, high)
        } else if (root.`val` > high) {
            return rangeSumBST(root.left, low, high)
        } else {
            return root.`val` + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high)
        }
    }
}
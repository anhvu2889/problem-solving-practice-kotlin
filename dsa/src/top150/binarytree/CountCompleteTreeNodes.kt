package top150.binarytree

import blind75.binarytree.TreeNode

/**
 * 222. Count Complete Tree Nodes
 * Time: O(h ^ 2)
 * Space: O(h)
 */
class CountCompleteTreeNodes {
    fun countNodes(root: TreeNode?): Int {
        var leftHeight = 0
        var cur = root
        while (cur != null) {
            leftHeight++
            cur = cur.left
        }
        var rightHeight = 0
        cur = root
        while (cur != null) {
            rightHeight++
            cur = cur.right
        }
        if (leftHeight == rightHeight)
            return (1 shl leftHeight) - 1
        return 1 + countNodes(root?.left) + countNodes(root?.right)
    }
}
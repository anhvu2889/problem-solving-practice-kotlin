package top150.binarytree

import blind75.binarytree.TreeNode

/**
 * 230. Kth Smallest Element in a BST
 * Time: O(h + k)
 * Space: O(h)
 */
class KthSmallestElementBST {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val stack = ArrayDeque<TreeNode>()
        var cur = root
        var count = 0
        while (cur != null || stack.isNotEmpty()) {
            while (cur != null) {
                stack.addLast(cur)
                cur = cur.left
            }
            val node = stack.removeLast()
            count++
            if (count == k)
                return node.`val`
            cur = node.right
        }
        return -1
    }
}
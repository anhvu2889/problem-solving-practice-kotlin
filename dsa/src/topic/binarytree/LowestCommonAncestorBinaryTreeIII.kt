package topic.binarytree

import blind75.binarytree.TreeNode

/**
 * 1650. Lowest Common Ancestor of a Binary Tree III
 * Time: O(h)
 * Space: O(1)
 */
class LowestCommonAncestorBinaryTreeIII {

    class Node(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
        var parent: Node? = null
    }

    fun lowestCommonAncestor(p: Node?, q: Node?): Node? {
        var a = p
        var b = q
        while (a !== b) {
            if (a == null) {
                a = q
            } else {
                a = a.parent
            }
            if (b == null) {
                b = p
            } else {
                b = b.parent
            }
        }
        return a
    }
}
package topic.binarytree

import blind75.binarytree.TreeNode

/**
 * 1644. Lowest Common Ancestor of a Binary Tree II
 * Time: O(n)
 * Space: O(h)
 */
class LowestCommonAncestorBinaryTreeII {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        val existsP = contains(root, p)  // existsP: is p really a node of this tree
        val existsQ = contains(root, q)  // existsQ: is q really a node of this tree
        if (!existsP || !existsQ) return null
        return findLca(root, p, q)  // candidate: deepest node with one target on each side
    }

    private fun contains(node: TreeNode?, target: TreeNode?): Boolean {
        if (node == null) return false
        if (node === target) return true
        return contains(node.left, target) || contains(node.right, target)  // contains: the node itself, or a child's subtree
    }

    private fun findLca(node: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (node == null) return null
        if (node === p || node === q) return node  // report(node): a target reports itself
        val left = findLca(node.left, p, q)    // left, right = the notes the two children hand up
        val right = findLca(node.right, p, q)
        if (left != null && right != null) return node  // report(node): notes from both sides, this node is the LCA
        if (left != null) return left
        return right
    }
}
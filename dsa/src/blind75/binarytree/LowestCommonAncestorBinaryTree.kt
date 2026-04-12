package blind75.binarytree

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * Time: O(n)
 * Space: O(h)
 */
class LowestCommonAncestorBinaryTree {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || root == p || root == q) return root

        val left = lowestCommonAncestor(root.left, p, q)
        val right = lowestCommonAncestor(root.right, p, q)

        if (left != null && right != null) return root

        return left ?: right
    }
}
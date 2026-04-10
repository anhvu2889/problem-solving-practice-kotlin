package blind75.binarytree

/**
 * 104. Maximum Depth of Binary Tree
 * Time: O(n)
 * Space: O(n)
 */
class MaximumDepthBinaryTree {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun maxDepth(root: TreeNode?): Int {
        return dfs(root)
    }

    fun dfs(root: TreeNode?): Int {
        if (root == null)
            return 0
        return 1 + maxOf(dfs(root.left), dfs(root.right))
    }
}
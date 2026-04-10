package blind75.binarytree

/**
 * 1448. Count Good Nodes in Binary Tree
 * Time: O(n)
 * Space: O(h)
 */
class CountGoodNodesBinaryTree {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun goodNodes(root: TreeNode?): Int {
        if (root == null)
            return -1
        return dfs(root, root.`val`)
    }

    fun dfs(root: TreeNode?, max: Int): Int {
        if (root == null)
            return 0
        val currentMax = maxOf(max, root.`val`)
        if (root.`val` >= currentMax) {
            return 1 + dfs(root.left, currentMax) + dfs(root.right, currentMax)
        } else {
            return 0 + dfs(root.left, currentMax) + dfs(root.right, currentMax)
        }
    }
}
package topic.binarytree

import blind75.binarytree.TreeNode

/**
 * 2331. Evaluate Boolean Binary Tree
 * Time: O(n)
 * Space: O(h)
 */
class EvaluateBooleanBinaryTree {
    fun evaluateTree(root: TreeNode?): Boolean {
        root?.let {
            return dfs(it)
        }
        return false
    }

    private fun dfs(node: TreeNode): Boolean {
        if (node.left == null || node.right == null) {
            return node.`val` == 1
        }
        return when(node.`val`) {
            2 -> dfs(node.left!!) || dfs(node.right!!)
            else -> dfs(node.left!!) && dfs(node.right!!)
        }
    }
}
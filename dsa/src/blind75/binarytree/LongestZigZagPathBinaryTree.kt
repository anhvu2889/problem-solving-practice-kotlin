package blind75.binarytree

/**
 * 1372. Longest ZigZag Path in a Binary Tree
 * Time: O(n)
 * Space: O(h)
 */
class LongestZigZagPathBinaryTree {
    fun longestZigZag(root: TreeNode?): Int {
        return dfs(root)[2]
    }

    fun dfs(node: TreeNode?): IntArray {
        if (node == null)
            return intArrayOf(0, 0, 0)
        val left = dfs(node.left)
        val right = dfs(node.right)

        var leftZigzac = 0
        var rightZigzac = 0
        if (node.left != null)
            leftZigzac = left[1] + 1
        if (node.right != null)
            rightZigzac = right[0] + 1
        val maxHere = maxOf(leftZigzac, rightZigzac, left[2], right[2])
        return intArrayOf(leftZigzac, rightZigzac, maxHere)
    }
}
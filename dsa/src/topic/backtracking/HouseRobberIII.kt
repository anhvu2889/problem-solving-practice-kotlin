package topic.backtracking

/**
 * 337. House Robber III
 * Time: O(n)
 * Space: O(h)
 */
class HouseRobberIII {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun rob(root: TreeNode?): Int {
        val result = dfs(root)
        return maxOf(result[0], result[1])
    }

    fun dfs(node: TreeNode?): IntArray {
        val result = IntArray(2)
        if (node == null)
            return result
        val left = dfs(node.left)
        val right = dfs(node.right)
        val robThis = node.`val` + left[1] + right[1]
        val notRobThis = maxOf(left[0], left[1]) + maxOf(right[0], right[1])
        result[0] = robThis
        result[1] = notRobThis
        return result
    }
}
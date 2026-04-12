package blind75.binarytree

/**
 * 437. Path Sum III
 * Time: O(n)
 * Space: O(n)
 */
class PathSumIII {
    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        val map = HashMap<Long, Int>()
        map[0L] = 1
        return dfs(root, targetSum, 0L, map)
    }

    fun dfs(node: TreeNode?, target: Int, sum: Long, map: HashMap<Long, Int>): Int {
        if (node == null)
            return 0
        val newSum: Long = sum + node.`val`
        val remain = newSum - target
        var count = map.getOrDefault(remain, 0)
        map[newSum] = map.getOrDefault(newSum, 0) + 1
        count = count + dfs(node.left, target, newSum, map) + dfs(node.right, target, newSum, map)
        map[newSum] = map.getOrDefault(newSum, 0) - 1
        return count
    }
}
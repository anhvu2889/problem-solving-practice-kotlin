package blind75.binarytree

/**
 * 1161. Maximum Level Sum of a Binary Tree
 * Time: O(n)
 * Space: O(n)
 */
class MaximumLevelSumBinaryTree {
    fun maxLevelSum(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        var level = 0
        var minLevel = 0
        var maxSum = Long.MIN_VALUE
        while (queue.isNotEmpty()) {
            val size = queue.size
            level++
            var sum = 0L
            repeat(size) {
                val node = queue.removeFirst()
                if (node.left != null)
                    queue.addLast(node.left!!)
                if (node.right != null)
                    queue.addLast(node.right!!)
                sum += node.`val`
            }
            if (sum > maxSum) {
                minLevel = level
                maxSum = sum
            }
        }
        return minLevel
    }
}
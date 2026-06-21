package top150.binarytree

import blind75.binarytree.TreeNode

/**
 * 637. Average of Levels in Binary Tree
 * Time: O(n)
 * Space: O(w)
 */
class AverageLevelBinaryTree {
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        val result = mutableListOf<Double>()
        if (root == null)
            return result.toDoubleArray()
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            var sum = 0.0
            repeat(size) {
                val node = queue.removeFirst()
                sum += node.`val`
                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }
            result.add(sum / size)
        }
        return result.toDoubleArray()
    }
}
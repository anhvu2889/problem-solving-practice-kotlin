package topic.binarytree

import blind75.binarytree.TreeNode

class CountNodesEqualAverageSubtree {
    fun averageOfSubtree(root: TreeNode?): Int {
        val count = countNodeEqualAvgSubtree(root)
        return count[2]
    }

    private fun countNodeEqualAvgSubtree(node: TreeNode?): IntArray {
        if (node == null) {
            return intArrayOf(0, 0, 0)
        }
        val left = countNodeEqualAvgSubtree(node.left)
        val right = countNodeEqualAvgSubtree(node.right)
        val value = left[0] + right[0] + node.`val`
        val count = left[1] + right[1] + 1
        val isEqualAvg = if (node.`val` == (value / count)) 1 else 0
        val countEqual = left[2] + right[2] + isEqualAvg
        return intArrayOf(value, count, countEqual)
    }
}
package topic.binarytree

import blind75.binarytree.TreeNode

/**
 * 549. Binary Tree Longest Consecutive Sequence II
 * Time: O(n)
 * Space: O(h)
 */
class BinaryTreeLongestConsecutiveSequenceII {
    fun longestConsecutive(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        return dfs(root)[2]
    }

    private fun dfs(node: TreeNode): IntArray {
        var bestIncreasing = 1
        var bestDecreasing = 1
        var bestAtNode = 1
        val leftNode = node.left
        val rightNode = node.right
        leftNode?.let {
            val left = dfs(it)
            if (it.`val` + 1 == node.`val`) {
                bestIncreasing = maxOf(left[0] + 1, bestIncreasing)
            }
            if (it.`val` - 1 == node.`val`) {
                bestDecreasing = maxOf(left[1] + 1, bestDecreasing)
            }
            bestAtNode = maxOf(bestAtNode, left[2])
        }
        rightNode?.let {
            val right = dfs(it)
            if (it.`val` + 1 == node.`val`) {
                bestIncreasing = maxOf(right[0] + 1, bestIncreasing)
            }

            if (it.`val` - 1 == node.`val`) {
                bestDecreasing = maxOf(right[1] + 1, bestDecreasing)
            }
            bestAtNode = maxOf(bestAtNode, right[2])
        }
        bestAtNode = maxOf(bestIncreasing + bestDecreasing - 1, bestAtNode)
        return intArrayOf(bestIncreasing, bestDecreasing, bestAtNode)
    }
}
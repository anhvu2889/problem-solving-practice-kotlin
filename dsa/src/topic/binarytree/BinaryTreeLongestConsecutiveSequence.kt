package topic.binarytree

import blind75.binarytree.TreeNode

/**
 * 298. Binary Tree Longest Consecutive Sequence
 * Time: O(n)
 * Space: O(h)
 */
class BinaryTreeLongestConsecutiveSequence {
//    fun longestConsecutive(root: TreeNode?): Int {
//        if (root == null) {
//            return 0
//        }
//        val stack = ArrayDeque<Pair<TreeNode, Int>>()
//        var best = 1
//        stack.addLast(Pair(root, 1))
//        while (stack.isNotEmpty()) {
//            val cur = stack.removeLast()
//            val node = cur.first
//            val longestAtNode = cur.second
//            best = maxOf(best, longestAtNode)
//            node.left?.let {
//                val nextLength = nextLength(node, it, longestAtNode)
//                stack.addLast(Pair(it, nextLength))
//            }
//            node.right?.let {
//                val nextLength = nextLength(node, it, longestAtNode)
//                stack.addLast(Pair(it, nextLength))
//            }
//        }
//        return best
//    }
//
//    private fun nextLength(parent: TreeNode, child: TreeNode, parentLength: Int ): Int {
//        if (child.`val` == parent.`val` + 1) {
//            return parentLength + 1
//        } else {
//            return 1
//        }
//    }


    fun longestConsecutive(root: TreeNode?): Int {
        return postOrder(root)[1]
    }

    private fun postOrder(node: TreeNode?): IntArray {
        if (node == null) {
            return intArrayOf(0, 0)
        }
        val leftResult = postOrder(node.left)
        val bestAtLeft = leftResult[0]
        val bestInLeft = leftResult[1]

        val rightResult = postOrder(node.right)
        val bestAtRight = rightResult[0]
        val bestInRight = rightResult[1]

        var bestAtNode = 1
        node.left?.let {
            if (node.`val` + 1 == it.`val`) {
                bestAtNode = maxOf(bestAtNode, 1 + bestAtLeft)
            }
        }
        node.right?.let {
            if (node.`val` + 1 == it.`val`) {
                bestAtNode = maxOf(bestAtNode, 1 + bestAtRight)
            }
        }
        val bestInNode = maxOf(bestAtNode, bestInRight, bestInLeft)
        return intArrayOf(bestAtNode, bestInNode)
    }
}
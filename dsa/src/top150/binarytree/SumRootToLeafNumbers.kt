package top150.binarytree

import blind75.binarytree.TreeNode

/**
 * 129. Sum Root to Leaf Numbers
 * Time:
 * Space:
 */
class SumRootToLeafNumbers {
    fun sumNumbers(root: TreeNode?): Int {
        var sum = 0
        val stack = ArrayDeque<Pair<TreeNode?, Int>>()
        stack.addLast(Pair(root, 0))
        while (stack.isNotEmpty()) {
            val (node, parentVal) = stack.removeLast()
            if (node == null)
                continue
            val curVal = parentVal * 10 + node.`val`
            if (node.left == null && node.right == null)
                sum += curVal
            stack.addLast(Pair(node.left, curVal))
            stack.addLast(Pair(node.right, curVal))
        }
        return sum
    }
}
package top150.binarytree

import blind75.binarytree.TreeNode

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * Time: O(n)
 * Space: O(w)
 */
class BinaryTreeZigzagLevelOrderTraversal {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if (root == null)
            return result
        val queue = ArrayDeque<TreeNode>()
        queue.addLast(root)
        var ltr = true
        while (queue.isNotEmpty()) {
            val size = queue.size
            val array = IntArray(size)
            var i = if (ltr) 0 else size - 1
            repeat(size) {
                val node = queue.removeFirst()
                array[i] = node.`val`
                i += if (ltr) 1 else -1
                node.left?.let { queue.addLast(it) }
                node.right?.let { queue.addLast(it) }
            }
            ltr = !ltr
            result.add(array.toList())
        }
        return result
    }
}
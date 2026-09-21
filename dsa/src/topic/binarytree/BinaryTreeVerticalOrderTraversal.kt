package topic.binarytree

import blind75.binarytree.TreeNode

/**
 * 314. Binary Tree Vertical Order Traversal
 * Time: O(n)
 * Space: O(n)
 */
class BinaryTreeVerticalOrderTraversal {
    fun verticalOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return listOf()
        }
        val ans = mutableListOf<List<Int>>()
        val queue = ArrayDeque<Pair<TreeNode, Int>>()
        val colMap = HashMap<Int, MutableList<Int>>()
        var minCol = 0
        var maxCol = 0
        queue.add(Pair(root, 0))
        while (queue.isNotEmpty()) {
            val cur = queue.removeFirst()
            val node = cur.first
            val col = cur.second
            colMap.getOrPut(col) { mutableListOf<Int>() }.add(node.`val`)
            minCol = minOf(minCol, col)
            maxCol = maxOf(maxCol, col)
            node.left?.let {
                queue.addLast(Pair(it, col - 1))
            }
            node.right?.let {
                queue.addLast(Pair(it, col + 1))
            }
        }
        for (col in minCol..maxCol) {
            colMap[col]?.let {
                ans.add(it)
            }
        }
        return ans
    }
}
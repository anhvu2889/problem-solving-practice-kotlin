package topic.binarytree

import blind75.binarytree.TreeNode

/**
 * 987. Vertical Order Traversal of a Binary Tree
 * Time: O( n * log(n))
 * Space: O(n)
 */
class VerticalOrderTraversalBinaryTree {
    fun verticalTraversal(root: TreeNode?): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        if (root == null) {
            return ans
        }
        val queue = ArrayDeque<Pair<TreeNode, Int>>()
        val colMap = HashMap<Int, MutableList<Int>>()
        queue.addLast(Pair(root, 0))
        var minCol = 0
        var maxCol = 0
        while (queue.isNotEmpty()) {
            val size = queue.size
            val rowMap = HashMap<Int, MutableList<Int>>()
            repeat(size) {
                val cur = queue.removeFirst()
                val node = cur.first
                val col = cur.second
                rowMap.getOrPut(col) { mutableListOf<Int>() }.add(node.`val`)
                minCol = minOf(col, minCol)
                maxCol = maxOf(col, maxCol)
                node.left?.let {
                    queue.addLast(Pair(it, col - 1))
                }
                node.right?.let {
                    queue.addLast(Pair(it, col + 1))
                }
            }
            for ((col, rowVals) in rowMap) {
                rowVals.sort()
                colMap.getOrPut(col) { mutableListOf() }.addAll(rowVals)
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
package blind75.binarytree

/**
 * 199. Binary Tree Right Side View
 * Time: O(n)
 * Space: O(n)
 */
class BinaryTreeRightSideView {

    fun rightSideView(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        if (root == null)
            return list
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0..<size) {
                val node = queue.removeFirst()
                if (node.left != null)
                    queue.add(node.left!!)
                if (node.right != null)
                    queue.add(node.right!!)
                if (i == size - 1)
                    list.add(node.`val`)
            }
        }
        return list
    }

}
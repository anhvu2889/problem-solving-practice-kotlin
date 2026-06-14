package topic.binarytree

import blind75.binarytree.TreeNode

/**
 * 2196. Create Binary Tree From Descriptions
 * Time: O(n)
 * Space: O(n)
 */
class CreateBinaryTreeFromDescriptions {
    fun createBinaryTree(descriptions: Array<IntArray>): TreeNode? {
        val map = HashMap<Int, TreeNode>()
        val childSet = HashSet<Int>()
        for (des in descriptions) {
            val parent = map.getOrDefault(des[0], TreeNode(des[0]))
            val child = map.getOrDefault(des[1], TreeNode(des[1]))
            if (des[2] == 1) {
                parent.left = child
            } else {
                parent.right = child
            }
            childSet.add(des[1])
            map[des[0]] = parent
            map[des[1]] = child
        }
        for (des in descriptions) {
            if (!childSet.contains(des[0])) {
                return map[des[0]]
            }
        }
        return null
    }
}
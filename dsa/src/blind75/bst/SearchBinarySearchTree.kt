package blind75.bst

import blind75.binarytree.TreeNode

/**
 * 700. Search in a Binary Search Tree
 * Time: O(h)
 * Space: O(1)
 */
class SearchBinarySearchTree {
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        var node = root
        while (node != null) {
            if (node.`val` == `val`)
                return node
            if (node.`val` > `val`)
                node = node.left
            else
                node = node.right
        }
        return null
    }
}
package blind75.bst

import blind75.binarytree.TreeNode

/**
 * 450. Delete Node in a BST
 * Time: O(h)
 * Space: O(h)
 */
class DeleteNodeBST {
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null)
            return null
        if (root.`val` > key)
            root.left = deleteNode(root.left, key)
        else if (root.`val` < key)
            root.right = deleteNode(root.right, key)
        else {
            if (root.left == null)
                return root.right
            else if (root.right == null)
                return root.left
            else {
                val successor = min(root.right!!)
                root.`val` = successor.`val`
                root.right = deleteNode(root.right, successor.`val`)
            }
        }
        return root
    }

    fun min(node: TreeNode): TreeNode {
        var cur = node
        while (cur.left != null) {
            cur = cur.left!!
        }
        return cur
    }
}
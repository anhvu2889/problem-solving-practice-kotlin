package top150.binarytree

import blind75.binarytree.TreeNode

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Time: O(n)
 * Space: O(n)
 */
class ConstructBinaryTreePreorderInorderTraversal {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val n = preorder.size
        val inorderMap = HashMap<Int, Int>()
        for (i in inorder.indices) {
            val value = inorder[i]
            inorderMap[value] = i
        }
        return buildTree(preorder, inorderMap, 0, n - 1, 0, n - 1)
    }

    fun buildTree(
        preorder: IntArray, inorderMap: Map<Int, Int>,
        preStart: Int, preEnd: Int, inStart: Int, inEnd: Int
    ): TreeNode? {
        if (preStart > preEnd)
            return null
        val midValue = preorder[preStart]
        val inMid = inorderMap[midValue]!!
        val leftSize = inMid - inStart
        val root = TreeNode(midValue)
        root.left = buildTree(preorder, inorderMap, preStart + 1, preStart + leftSize, inStart, inMid - 1)
        root.right = buildTree(preorder, inorderMap, preStart + leftSize + 1, preEnd, inMid + 1, inEnd)
        return root
    }
}
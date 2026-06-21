package top150.binarytree

import blind75.binarytree.TreeNode

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * Time: O(n)
 * Space: O(n)
 */
class ConstructBinaryTreeInorderPostorderTraversal {
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        val inorderMap = HashMap<Int, Int>()
        val n = inorder.size
        for (i in inorder.indices) {
            val value = inorder[i]
            inorderMap[value] = i
        }
        return buildTree(postorder, inorderMap, 0, n - 1, 0, n - 1)
    }

    fun buildTree(
        postorder: IntArray, inorderMap: Map<Int, Int>,
        postStart: Int, postEnd: Int, inStart: Int, inEnd: Int
    ): TreeNode? {
        if (postStart > postEnd)
            return null
        val midValue = postorder[postEnd]
        val inMid = inorderMap[midValue]!!
        val leftSize = inMid - inStart
        val root = TreeNode(midValue)
        root.left = buildTree(postorder, inorderMap, postStart, postStart + leftSize - 1, inStart, inMid - 1)
        root.right = buildTree(postorder, inorderMap, postStart + leftSize, postEnd - 1, inMid + 1, inEnd)
        return root
    }
}
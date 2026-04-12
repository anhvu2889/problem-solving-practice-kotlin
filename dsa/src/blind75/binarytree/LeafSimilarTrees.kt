package blind75.binarytree

/**
 * 872. Leaf-Similar Trees
 * Time: O(n1 + n2)
 * Space: O(n1 + h1 + n2 + h2)
 */
class LeafSimilarTrees {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()
        dfs(root1, list1)
        dfs(root2, list2)
        return list1 == list2
    }

    fun dfs(root: TreeNode?, list: MutableList<Int>) {
        if (root == null)
            return
        if (root.left == null && root.right == null) {
            list.add(root.`val`)
            return
        }
        dfs(root.left, list)
        dfs(root.right, list)
    }
}
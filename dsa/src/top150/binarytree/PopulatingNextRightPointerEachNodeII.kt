package top150.binarytree

/**
 * 117. Populating Next Right Pointers in Each Node II
 * Time: O(n)
 * Space: O(1)
 */
class PopulatingNextRightPointerEachNodeII {
    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
        var next: Node? = null
    }

    fun connect(root: Node?): Node? {
        if (root == null)
            return null
        var cur = root
        while (cur != null) {
            val nextLevelDummy = Node(0)
            var levelTail: Node = nextLevelDummy
            while (cur != null) {
                cur.left?.let {
                    levelTail.next = it
                    levelTail = it
                }
                cur.right?.let {
                    levelTail.next = it
                    levelTail = it
                }
                cur = cur.next
            }
            cur = nextLevelDummy.next
        }
        return root
    }
}
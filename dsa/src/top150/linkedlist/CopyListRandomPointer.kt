package top150.linkedlist

/**
 * 138. Copy List with Random Pointer
 * Time: O(n)
 * Space: O(1)
 */
class CopyListRandomPointer {
    class Node(var `val`: Int) {
        var next: Node? = null
        var random: Node? = null
    }

    fun copyRandomList(node: Node?): Node? {
        var dummy = Node(0)
        dummy.next = node
        var cur = dummy.next
        while (cur != null) {
            val clone = Node(cur.`val`)
            clone.next = cur.next
            cur.next = clone
            cur = clone.next
        }
        cur = dummy.next
        while (cur != null) {
            val clone = cur.next
            val next = clone?.next
            clone?.random = cur.random?.next
            cur = next
        }
        cur = dummy.next
        val ans = cur?.next
        while (cur != null) {
            val clone = cur.next
            val next = clone?.next

            cur.next = next
            clone?.next = next?.next

            cur = next
        }
        return ans
    }
}
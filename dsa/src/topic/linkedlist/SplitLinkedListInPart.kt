package topic.linkedlist

/**
 * 725. Split Linked List in Parts
 * Time: O(n)
 * Space: O(1)
 */
class SplitLinkedListInPart {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
        var size = 0
        var cur = head
        while (cur != null) {
            size++
            cur = cur.next
        }
        val min = size / k
        val remaining = size % k
        val list = Array<ListNode?>(k) { null }
        cur = head
        for (i in 0..<k) {
            val nodeHead = cur
            val partSize = if (i < remaining) min + 1 else min
            var prev: ListNode? = null
            for (j in 0..<partSize) {
                prev = cur
                if (cur != null) {
                    cur = cur.next
                }

            }
            if (prev != null) {
                prev.next = null
            }
            list[i] = nodeHead
        }
        return list
    }
}
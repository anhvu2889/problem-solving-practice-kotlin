package top150.linkedlist

import topic.linkedlist.ListNode

/**
 * 92. Reverse Linked List II
 * Time: O(n)
 * Space: O(1)
 */
class ReverseLinkedListII {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var beforeLeft: ListNode? = dummy
        repeat(left - 1) {
            beforeLeft = beforeLeft?.next
        }
        var cur = beforeLeft?.next
        val revTail = beforeLeft?.next
        var prev: ListNode? = null
        repeat (right - left + 1) {
            val next = cur?.next
            cur?.next = prev
            prev = cur
            cur = next
        }
        beforeLeft?.next = prev
        revTail?.next = cur
        return dummy.next
    }

}
package top150.linkedlist

import topic.linkedlist.ListNode

/**
 * 82. Remove Duplicates from Sorted List II
 * Time: O(n)
 * Space: O(1)  
 */
class RemoveDuplicatesSortedListII {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var prev: ListNode? = dummy
        var cur: ListNode? = dummy.next
        while (cur != null) {
            if (cur.next != null && cur.`val` == cur.next?.`val`) {
                val dupVal = cur.`val`
                while (cur != null && cur.`val` == dupVal) {
                    cur = cur.next
                }
                prev?.next = cur
            } else {
                prev = cur
                cur = cur.next
            }
        }
        return dummy.next
    }
}
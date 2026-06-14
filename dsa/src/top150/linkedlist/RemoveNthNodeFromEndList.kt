package top150.linkedlist

import topic.linkedlist.ListNode

/**
 * 19. Remove Nth Node From End of List
 * Time: O(n)
 * Space: O(1)
 */
class RemoveNthNodeFromEndList {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var fast: ListNode? = dummy.next
        repeat(n) {
            fast = fast?.next
        }
        var slow =  dummy.next
        var prev: ListNode? = dummy
        var next: ListNode? = slow?.next
        while (fast != null) {
            prev = slow
            slow = slow?.next
            next = slow?.next
            fast = fast?.next
        }
        slow?.next = null
        prev?.next = next
        return dummy.next
    }
}
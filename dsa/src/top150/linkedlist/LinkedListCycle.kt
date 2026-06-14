package top150.linkedlist

import topic.linkedlist.ListNode


/**
 * 141. Linked List Cycle
 * Time: O(n)
 * Time: O(1)
 */
class LinkedListCycle {
    fun hasCycle(head: ListNode?): Boolean {
        var slow = head
        var fast = head
        while (slow != null && fast?.next != null) {
            slow = slow.next
            fast = fast.next?.next
            if (slow == fast)
                return true
        }
        return false
    }
}
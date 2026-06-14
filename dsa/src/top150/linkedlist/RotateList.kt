package top150.linkedlist

import topic.linkedlist.ListNode

/**
 * 61. Rotate List
 * Time: O(n)
 * Space: O(1)
 */
class RotateList {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head?.next == null ||k == 0)
            return head
        val dummy = ListNode(0)
        dummy.next = head
        var tail: ListNode? = dummy
        var n = 0
        while (tail != null && tail.next != null) {
            tail = tail.next
            n++
        }
        var newTail: ListNode? = dummy
        repeat (n - k % n) {
            newTail = newTail?.next
        }
        tail?.next = head
        dummy.next = newTail?.next
        newTail?.next = null
        return dummy.next
    }
}
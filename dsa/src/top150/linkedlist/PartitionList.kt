package top150.linkedlist

import topic.linkedlist.ListNode

/**
 * 86. Partition List
 * Time: O(n)
 * Space: O(1)
 */
class PartitionList {
    fun partition(head: ListNode?, x: Int): ListNode? {
        val leftDummy = ListNode(0)
        val rightDummy = ListNode(0)
        var left: ListNode? = leftDummy
        var right: ListNode? = rightDummy
        var cur = head
        while (cur != null) {
            if (cur.`val` < x) {
                left?.next = cur
                left = left?.next
            } else {
                right?.next = cur
                right = right?.next
            }
            cur = cur.next
        }
        right?.next = null
        left?.next = rightDummy.next
        return leftDummy.next
    }
}
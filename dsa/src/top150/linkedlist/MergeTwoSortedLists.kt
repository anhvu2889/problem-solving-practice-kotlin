package top150.linkedlist

import topic.linkedlist.ListNode

/**
 * 21. Merge Two Sorted Lists
 * Time: O(n)
 * Space: O(1)
 */
class MergeTwoSortedLists {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var p1 = list1
        var p2 = list2
        var cur: ListNode? = dummy
        while (p1 != null || p2 != null) {
            val num1 = p1?.`val` ?: 101
            val num2 = p2?.`val` ?: 101
            if (num1 < num2) {
                cur?.next = ListNode(num1)
                p1 = p1?.next
            } else {
                cur?.next = ListNode(num2)
                p2 = p2?.next
            }
            cur = cur?.next
        }
        return dummy.next
    }
}
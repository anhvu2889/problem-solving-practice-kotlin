package top150.linkedlist

import topic.linkedlist.ListNode

/**
 * 2. Add Two Numbers
 * Time: O(m + n)
 * Space: O(1)
 */
class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var dummy = ListNode(0)
        var p1 = l1
        var p2 = l2
        var carry = 0
        var cur: ListNode? =  dummy
        while (p1 != null || p2 != null || carry > 0) {
            val num1 = p1?.`val` ?: 0
            val num2 = p2?.`val` ?: 0
            val sum = num1 + num2 + carry
            cur?.next = ListNode(sum % 10)
            carry = sum / 10
            cur = cur?.next
            p1 = p1?.next
            p2 = p2?.next
        }
        return dummy.next
    }
}
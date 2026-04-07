package blind75.linkedlist

/**
 * 2130. Maximum Twin Sum of a Linked List
 * Time:
 * Space:
 */
class MaximumTwinSumLinkedList {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun pairSum(head: ListNode?): Int {
        var slow = head
        var fast = head
        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        var first = head
        var second = reverse(slow)
        var max = 0
        while (second != null) {
            max = maxOf(max, second.`val` + first!!.`val`)
            second = second.next
            first = first.next
        }
        return max
    }

    fun reverse(head: ListNode?): ListNode? {
        if (head == null)
            return null
        var cur = head
        var prev: ListNode? = null
        while (cur != null) {
            val next = cur.next
            cur.next = prev
            prev = cur
            cur = next
        }
        return prev
    }
}
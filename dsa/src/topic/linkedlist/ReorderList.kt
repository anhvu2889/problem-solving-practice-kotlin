package topic.linkedlist

/**
 * 143. Reorder List
 * Time: O(n)
 * Space: O(1)
 */
class ReorderList {
    fun reorderList(head: ListNode?): Unit {
        if (head == null) {
            return
        }
        val firstHalfEnd = findFirstHalfEnd(head)
        val secondHead = firstHalfEnd.next
        firstHalfEnd.next = null
        val reversedSecondHead = reverse(secondHead)
        merge(head, reversedSecondHead)
    }

    private fun findFirstHalfEnd(head: ListNode): ListNode {
        var slow = head
        var fast = head
        while (fast.next != null && fast.next!!.next != null) {
            slow = slow.next!!
            fast = fast.next!!.next!!
        }
        return slow
    }

    private fun reverse(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var cur = head
        while (cur != null) {
            val temp = cur.next
            cur.next = prev
            prev = cur
            cur = temp
        }
        return prev
    }

    private fun merge(firstHead: ListNode?, secondHead: ListNode?) {
        var first = firstHead
        var second = secondHead
        while (first != null && second != null) {
            val firstNext = first.next
            val secondNext = second.next
            first.next = second
            second.next = first.next
            first = firstNext
            second = secondNext
        }
    }
}
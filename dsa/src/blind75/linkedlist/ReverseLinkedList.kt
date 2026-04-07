package blind75.linkedlist

/**
 * 206. Reverse Linked List
 * Time: O(n)
 * Space: O(1)
 */
class ReverseLinkedList {
    class ListNode(var value: Int) {
        var next: ListNode? = null
    }

    fun reverseList(head: ListNode?): ListNode? {
        if (head == null)
            return null
        var cur = head
        var prev: ListNode? = null
        while(cur != null) {
            val next = cur.next
            cur.next = prev
            prev = cur
            cur = next
        }
        return prev
    }
}
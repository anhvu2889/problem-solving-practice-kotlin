package blind75.linkedlist

/**
 * 328. Odd Even Linked List
 * Time: O(n)
 * Space: O(1)
 */
class OddEvenLinkedList {
    class ListNode(var value: Int) {
        var next: ListNode? = null
    }

    fun oddEvenList(head: ListNode?): ListNode? {
        if (head == null)
            return null
        var odd = head
        var even = head.next
        var evenHead = even
        while (even != null && even.next != null) {
            odd?.next = even.next
            odd = odd?.next
            even.next = odd?.next
            even = even.next
        }
        odd?.next = evenHead
        return head
    }
}
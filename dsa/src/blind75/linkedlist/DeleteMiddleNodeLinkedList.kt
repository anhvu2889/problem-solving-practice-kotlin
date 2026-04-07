package blind75.linkedlist

/**
 * 2095. Delete the Middle Node of a Linked List
 * Time: O(n)
 * Space: O(1)
 */
class DeleteMiddleNodeLinkedList {
    class ListNode(var value: Int) {
        var next: ListNode? = null
    }

    fun deleteMiddle(head: ListNode?): ListNode? {
        if (head?.next == null)
            return null
        var slow = head
        var fast = head.next?.next
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        slow?.next = slow?.next?.next
        return head
    }
}
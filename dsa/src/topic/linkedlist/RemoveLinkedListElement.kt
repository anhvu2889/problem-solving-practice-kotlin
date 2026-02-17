package topic.linkedlist

/**
 * 203. Remove Linked List Elements
 * Time: O(n)
 * Space: O(1)
 */
class RemoveLinkedListElement {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun removeElements(head: ListNode?, k: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var prev = dummy
        var cur = head
        while (cur != null) {
            if (cur.`val` == k) {
                prev.next = cur.next
                cur = cur.next
            } else {
                prev = cur
                cur = cur.next
            }
        }
        return dummy.next
    }
}
package topic.fastslowpointer

/**
 *  141. Linked List Cycle
 *  Time:
 *  Space
 */
class LinkedListCycle {
    class ListNode(var value: Int) {
        var next: ListNode? = null
    }

    fun hasCycle(head: ListNode?): Boolean {
        if (head?.next == null) {
            return false
        }
        var slow = head
        var fast = head.next
        while (fast?.next != null) {
            if (slow == fast) {
                return true
            }
            slow = slow?.next
            fast = fast.next?.next
        }
        return false
    }
}
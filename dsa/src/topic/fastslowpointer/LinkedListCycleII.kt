package topic.fastslowpointer

/**
 * 142. Linked List Cycle II
 * Time: O(n)
 * Space: O(1)
 */
class LinkedListCycleII {
    class ListNode(var value: Int) {
        var next: ListNode? = null
    }

    fun detectCycle(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return null
        }
        var slow = head
        var fast = head
        var hasCycle = false
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
            if (slow == fast) {
                hasCycle = true
                break
            }
        }
        if (!hasCycle) {
            return null
        }
        slow = head
        while (slow != fast) {
            slow = slow?.next
            fast = fast?.next
        }
        return slow
    }
}
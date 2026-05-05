package topic.linkedlist

/**
 * 61. Rotate List
 * Time: O(n)
 * Space: O(1)
 */
class RotateList {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head == null)
            return null
        var tail = head
        var n = 1
        while (tail?.next != null) {
            tail = tail.next
            n++
        }
        val rotate = k % n
        if (rotate == 0)
            return head
        tail?.next = head
        var newTail = head
        repeat(n - rotate - 1) {
            newTail = newTail?.next
        }
        var newHead = newTail?.next
        newTail?.next = null
        return newHead
    }
}
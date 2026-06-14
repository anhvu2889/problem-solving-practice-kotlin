package top150.linkedlist

import topic.linkedlist.ListNode

/**
 * 25. Reverse Nodes in k-Group
 * Time: O(n)
 * Space: O(1)
 */
class ReverseNodesInKGroup {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var groupPrev: ListNode = dummy
        while (true) {
            val groupTail = getGroupTailAfterKNode(groupPrev, k) ?: break
            val groupHead = groupPrev.next!!
            val groupNext = groupTail.next
            reverseGroup(groupHead, k)
            groupPrev.next = groupTail
            groupHead.next = groupNext
            groupPrev = groupHead
        }
        return dummy.next
    }

    private fun reverseGroup(head: ListNode?, k: Int) {
        var prev: ListNode? = null
        var cur: ListNode? = head
        repeat(k) {
            val temp = cur?.next
            cur?.next = prev
            prev = cur
            cur = temp
        }
    }

    private fun getGroupTailAfterKNode(groupPrev: ListNode, k: Int): ListNode? {
        var cur: ListNode? = groupPrev
        repeat(k) {
            cur = cur?.next
            if (cur == null)
                return null
        }
        return cur
    }
}
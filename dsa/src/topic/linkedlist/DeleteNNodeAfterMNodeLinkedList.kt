package topic.linkedlist

/**
 * 1474. Delete N Nodes After M Nodes of a Linked List
 * Time: O(n)
 * Space: O(1)
 */
class DeleteNNodeAfterMNodeLinkedList {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun deleteNodes(head: ListNode?, m: Int, n: Int): ListNode? {
        val dummy = ListNode(-1)
        dummy.next = head
        var cur = head
        var prev: ListNode? = null
        while (cur != null) {
            for (i in 0..<m) {
                if (cur == null) {
                    break
                }
                prev = cur
                cur = cur.next
            }
            for (i in 0 ..< n){
                if (cur == null) {
                    break
                }
                cur = cur.next
            }
            prev?.next = cur
        }
        return dummy.next
    }
}
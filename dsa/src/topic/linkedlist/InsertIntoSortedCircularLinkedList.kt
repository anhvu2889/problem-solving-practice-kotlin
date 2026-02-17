package topic.linkedlist

/**
 * 708. Insert into a Sorted Circular Linked List
 * Time: O(n)
 * Space: O(1)
 */
class InsertIntoSortedCircularLinkedList {
    class Node(var `val`: Int) {
        var next: Node? = null
    }

    fun insert(head: Node?, insertVal: Int): Node {
        if (head == null) {
            val node = Node(insertVal)
            node.next = node
            return node
        }
        var cur = head
        do {
            val next = cur?.next
            if (next != null && cur != null && insertVal >= cur.`val` && insertVal <= next.`val`) {
                break
            }
            if (next != null && cur != null && cur.`val` > next.`val` && (insertVal >= cur.`val` || insertVal <= next.`val`)) {
                break
            }
            cur = next
        } while (cur !== head)
        val node = Node(insertVal)
        node.next = cur?.next
        cur?.next = node
        return head
    }
}
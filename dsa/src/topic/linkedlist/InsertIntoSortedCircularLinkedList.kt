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

    fun insert(head: Node?, insertVal: Int): Node? {
        val newNode = Node(insertVal)
        if (head == null) {
            newNode.next = newNode
            return newNode
        }
        val prev = findGap(head, insertVal)
        newNode.next = prev.next
        prev.next = newNode
        return head
    }

    private fun findGap(head: Node, newValue: Int): Node {
        var cur = head
        do {
            val next = cur.next!!
            if (cur.`val` <= newValue && next.`val` >= newValue) {
                break
            }
            if (cur.`val` > next.`val` && (newValue >= cur.`val` && newValue <= next.`val`)) {
                break
            }
            cur = next
        } while (cur !== head)
        return cur
    }
}
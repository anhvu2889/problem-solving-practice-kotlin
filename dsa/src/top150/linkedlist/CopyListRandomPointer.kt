package top150.linkedlist

/**
 * 138. Copy List with Random Pointer
 * Time: O(n)
 * Space: O(1)
 */
class CopyListRandomPointer {
    class Node(var `val`: Int) {
        var next: Node? = null
        var random: Node? = null
    }

    fun copyRandomList(node: Node?): Node? {
        if (node == null) {
            return null
        }
        weaveNext(node)
        weaveRandom(node)
        return unweave(node)
    }

    private fun weaveNext(node: Node?) {
        var cur = node
        // Weave next: A -> A' -> B -> B' -> C -> C'
        while (cur != null) {
            val clone = Node(cur.`val`)
            clone.next = cur.next
            cur.next = clone
            cur = clone.next
        }
    }

    private fun weaveRandom(node: Node?) {
        var cur = node
        while (cur != null) {
            val clone = cur.next!!
            clone.random = cur.random?.next
            cur = clone.next
        }
    }

    private fun unweave(node: Node): Node {
        var cloneHead = node.next!!
        var cur: Node? = node
        while (cur != null) {
            val clone = cur.next
            cur.next = clone?.next
            clone?.next = clone.next?.next
            cur = cur.next
        }
        return cloneHead
    }
}
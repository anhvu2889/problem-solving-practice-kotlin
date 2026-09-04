package top150.linkedlist

/**
 * 146. LRU Cache
 *
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 *
 * Time: O(1)
 * Space: O(n)
 */
class LRUCache(val capacity: Int) {

    private class Node(val key: Int, var value: Int) {
        var prev: Node? = null
        var next: Node? = null
    }

    private val map = HashMap<Int, Node>()
    private val head = Node(0, 0)
    private val tail = Node(0, 0)

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        val node = map[key]
        if (node == null) {
            return -1
        }
        moveToFront(node)
        return node.value

    }

    fun put(key: Int, value: Int) {
        val node = map[key]
        if (node != null) {
            putExistingNode(node, value)
            return
        }
        if (map.size == capacity) {
            evict()
        }
        putNewNode(key, value)
    }

    private fun putExistingNode(node: Node, newValue: Int) {
        node.value = newValue
        moveToFront(node)
    }

    private fun putNewNode(key: Int, value: Int) {
        val node = Node(key, value)
        addFront(node)
        map[key] = node
    }

    private fun evict() {
        val lru = tail.prev!!
        unlink(lru)
        map.remove(lru.key)
    }

    private fun unlink(node: Node) {
        val prev = node.prev!!
        val next = node.next!!
        prev.next = next
        next.prev = prev
    }

    private fun addFront(node: Node) {
        val first = head.next!!
        head.next = node
        node.prev = head
        node.next = first
        first.prev = node
    }

    private fun moveToFront(node: Node) {
        unlink(node)
        addFront(node)
    }
}
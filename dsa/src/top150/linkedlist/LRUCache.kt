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
class LRUCache(capacity: Int) {

    private class Node(val key: Int, var value: Int) {
        var prev: Node? = null
        var next: Node? = null
    }

    private val map = HashMap<Int, Node>()
    private val head = Node(0, 0)
    private val tail = Node(0, 0)
    private val cap = capacity

    init {
        head.next = tail
        tail.prev = head
    }

    private fun removeNode(node: Node) {
        node.prev!!.next = node.next
        node.next!!.prev = node.prev
    }

    private fun insertAfterHead(node: Node) {
        head.next!!.prev = node
        node.next = head.next
        node.prev = head
        head.next = node

    }

    fun get(key: Int): Int {
        if (!map.containsKey(key)) {
            return -1
        }
        val node = map[key]
        removeNode(node!!)
        insertAfterHead(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        if (map.containsKey(key)) {
            val node = map[key]!!
            node.value = value
            removeNode(node)
            insertAfterHead(node)
        } else {
            if (map.size == cap) {
                val least = tail.prev!!
                removeNode(least)
                map.remove(least.key)
            }
            val node = Node(key, value)
            map[key] = node
            insertAfterHead(node)
        }
    }
}
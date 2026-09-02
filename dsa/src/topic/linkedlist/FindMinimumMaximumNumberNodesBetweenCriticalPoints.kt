package topic.linkedlist

class FindMinimumMaximumNumberNodesBetweenCriticalPoints {
    fun nodesBetweenCriticalPoints(head: ListNode?): IntArray {
        var prev = head ?: return intArrayOf(-1, -1)
        var cur = prev.next ?: return intArrayOf(-1, -1)
        var index = 1
        var first = -1
        var last = -1
        var minGap = Int.MAX_VALUE
        while (true) {
            val next = cur.next ?: break
            val p = prev.`val`
            val c = cur.`val`
            val n = next.`val`
            if ((c > p && c > n) || (c < p && c < n)) {
                if (first == -1) first = index else minGap = minOf(minGap, index - last)
                last = index
            }
            index++
            prev = cur
            cur = next
        }
        return if (first == last) intArrayOf(-1, -1) else intArrayOf(minGap, last - first)
    }
}
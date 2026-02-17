package topic.heap

import java.util.*

/**
 * 1405. Longest Happy String
 * Time: O(k)
 * Space: O(1)
 */
class LongestHappyString {
    data class Freq(val count: Int, val char: Char)

    fun longestDiverseString(a: Int, b: Int, c: Int): String {
        val maxHeap = PriorityQueue<Freq>(compareByDescending { it -> it.count })
        if (a > 0) maxHeap.add(Freq(a, 'a'))
        if (b > 0) maxHeap.add(Freq(b, 'b'))
        if (c > 0) maxHeap.add(Freq(c, 'c'))
        val sb = StringBuilder()
        while (!maxHeap.isEmpty()) {
            val top = maxHeap.poll()
            val l = sb.length
            if (l >= 2 && sb[l - 1] == top.char && sb[l - 2] == top.char) {
                if (maxHeap.isEmpty()) {
                    break
                }
                val next = maxHeap.poll()
                sb.append(next.char)
                if (next.count > 1) {
                    maxHeap.add(Freq(next.count - 1, next.char))
                }
                maxHeap.add(top)
            } else {
                sb.append(top.char)
                if (top.count > 1) {
                    maxHeap.add(Freq(top.count - 1, top.char))
                }
            }
        }
        return sb.toString()
    }
}
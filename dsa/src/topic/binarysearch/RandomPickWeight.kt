package topic.binarysearch

import kotlin.random.Random

/**
 * 528. Random Pick with Weight
 * Time: O(log(n))
 * Space: O(n)
 */
class RandomPickWeight(w: IntArray) {
    private val prefix = buildPrefix(w)
    private val total = prefix[prefix.size - 1]
    fun pickIndex(): Int {
        val ticket = Random.nextInt(1, total + 1)
        return findOwner(prefix, ticket)
    }

    private fun buildPrefix(weights: IntArray): IntArray {
        val prefix = IntArray(weights.size)
        prefix[0] = weights[0]
        for (i in 1 until weights.size) {
            prefix[i] = prefix[i - 1] + weights[i]
        }
        return prefix
    }

    private fun findOwner(prefix: IntArray, ticket: Int): Int {
        var low = 0
        var high = prefix.size - 1
        while (low < high) {
            val mid = low + (high - low) / 2
            if (prefix[mid] >= ticket) {
                high = mid
            } else {
                low = mid + 1
            }
        }
        return low
    }
}
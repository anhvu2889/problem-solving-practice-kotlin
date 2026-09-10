package topic.hashmap

/**
 * 1636. Sort Array by Increasing Frequency
 * Time: O(nlog(n))
 * Space: O(n)
 */
class SortArrayIncreasingFrequency {
    private val RANGE = 201
    private val OFFSET = 100
    fun frequencySort(nums: IntArray): IntArray {

        val n = nums.size
        val freq = IntArray(RANGE)
        for (num in nums) {
            freq[num + OFFSET]++
        }
        val distinct = mutableListOf<Int>()
        for (i in freq.indices) {
            if (freq[i] > 0) {
                distinct.add(i - OFFSET)
            }
        }
        distinct.sortWith { a, b -> compareByFreq(a, b, freq) }
        return buildSortedArray(distinct, freq, n)
    }

    private fun compareByFreq(a: Int, b: Int, freq: IntArray): Int {
        val fa = freq[a + OFFSET]
        val fb = freq[b + OFFSET]
        if (fa != fb) {
            return fa - fb
        } else {
            return b - a
        }
    }

    private fun buildSortedArray(distinct: MutableList<Int>, freq: IntArray, n: Int): IntArray {
        val ans = IntArray(n)
        var i = 0
        for (num in distinct) {
            val count = freq[num + OFFSET]
            repeat(count) {
                ans[i] = num
                i++
            }
        }
        return ans
    }
}
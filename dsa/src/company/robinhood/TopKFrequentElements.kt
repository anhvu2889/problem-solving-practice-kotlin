package company.robinhood

/**
 * 347. Top K Frequent Elements
 * Time: O(n)
 * Space: O(n)
 */
class TopKFrequentElements {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val n = nums.size
        val freqMap = HashMap<Int, Int>()
        val ans = mutableListOf<Int>()
        for (num in nums) {
            freqMap[num] = (freqMap[num] ?: 0) + 1
        }
        val bucket = Array(n + 1) { mutableListOf<Int>() }
        for ((num, count) in freqMap) {
            bucket[count].add(num)
        }
        for (i in n downTo 1) {
            for (num in bucket[i]) {
                ans.add(num)
                if (ans.size == k)
                    return ans.toIntArray()
            }
        }
        return ans.toIntArray()
    }
}
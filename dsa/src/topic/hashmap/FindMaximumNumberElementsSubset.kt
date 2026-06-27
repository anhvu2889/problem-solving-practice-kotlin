package topic.hashmap

/**
 * 3020. Find the Maximum Number of Elements in Subset
 * Time: O(n)
 * Space: O(n)
 */
class FindMaximumNumberElementsSubset {
    fun maximumLength(nums: IntArray): Int {
        val freq = HashMap<Long, Int>()
        for (n in nums) {
            val key = n.toLong()
            freq[key] = freq.getOrDefault(key, 0) + 1
        }

        var answer = 1
        val ones = freq.getOrDefault(1L, 0)
        if (ones >= 1) {
            answer = if (ones % 2 == 1) ones else ones - 1
        }

        for (base in freq.keys) {
            if (base == 1L) continue
            var pairs = 0
            var current = base
            while (freq.getOrDefault(current, 0) >= 2) {
                pairs++
                current *= current
            }
            val length = if (freq.getOrDefault(current, 0) >= 1) pairs * 2 + 1 else pairs * 2 - 1
            if (length > answer) answer = length
        }

        return answer
    }
}
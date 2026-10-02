package topic.hashmap

/**
 * 2023. Number of Pairs of Strings With Concatenation Equal to Target
 * Time: O(n + l ^ 2)
 * Space: O(n)
 */
class NumberPairsStringsWithConcatenationEqualTarget {
    fun numOfPairs(nums: Array<String>, target: String): Int {
        val map = HashMap<String, Int>()
        var count = 0
        for (num in nums) {
            val curFreq = map.getOrDefault(num, 0)
            map[num] = curFreq + 1
        }
        for (len in 1 until target.length) {
            val prefix = target.substring(0, len)
            val suffix = target.substring(len)
            val prefixCount = map.getOrDefault(prefix, 0)
            val suffixCount = map.getOrDefault(suffix, 0)
            if (prefix == suffix) {
                count += prefixCount * (prefixCount - 1)
            } else {
                count += prefixCount * suffixCount
            }
        }
        return count
    }
}
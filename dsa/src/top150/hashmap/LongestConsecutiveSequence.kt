package top150.hashmap

/**
 * 128. Longest Consecutive Sequence
 * Time: O(n)
 * Space: O(n)
 */
class LongestConsecutiveSequence {
    fun longestConsecutive(nums: IntArray): Int {
        val set = nums.toSet()
        var max = 0
        for (num in set) {
            if (num - 1 !in set) {
                var cur = num
                var range = 0
                while (cur++ in set) {
                    range++
                }
                max = maxOf(range, max)
            }
        }
        return max
    }
}
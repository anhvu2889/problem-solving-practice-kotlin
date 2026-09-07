package topic.prefixsum

/**
 * 3903. Smallest Stable Index I
 * Time: O(n)
 * SpacE: O(n)
 */
class SmallestStableIndexI {
    fun firstStableIndex(nums: IntArray, k: Int): Int {
        val n = nums.size
        val prefix = IntArray(n)
        val suffix = IntArray(n)
        var max = Int.MIN_VALUE
        var min = Int.MAX_VALUE
        for (i in 0 until n) {
            max = maxOf(max, nums[i])
            prefix[i] = max
        }

        for (i in n - 1 downTo 0) {
            min = minOf(min, nums[i])
            suffix[i] = min
        }

        for (i in 0 until n) {
            val score = prefix[i] - suffix[i]
            if (score <= k) {
                return i
            }
        }
        return -1
    }
}
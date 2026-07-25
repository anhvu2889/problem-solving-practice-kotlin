package top150.dp

/**
 * 300. Longest Increasing Subsequence
 * Time: O(n * log(n))
 * Space: O(n)
 */
class LongestIncreasingSubsequence {
    fun lengthOfLIS(nums: IntArray): Int {
        val n = nums.size
        var max = 0
        val tails = IntArray(n)
        for (num in nums) {
            var l = 0
            var r = max
            while (l < r) {
                val mid = l + (r - l) / 2
                if (tails[mid] < num)
                    l = mid + 1
                else
                    r = mid
            }
            tails[l] = num
            if (l == max)
                max++
        }
        return max
    }
}
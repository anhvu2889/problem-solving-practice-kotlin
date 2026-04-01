package blind75.slidingwindow

/**
 * 1004. Max Consecutive Ones III
 * Time: O(n)
 * Space: O(1)
 */
class MaxConsecutiveOnesIII {
    fun longestOnes(nums: IntArray, k: Int): Int {
        var l = 0
        var max = 0
        var count = 0
        for (r in nums.indices) {
            if (nums[r] == 0) {
                count++
            }
            while (count > k) {
                if (nums[l] == 0)
                    count--
                l++
            }
            max = maxOf(max, r - l + 1)
        }
        return max
    }
}
package top150.twopointer

/**
 * 15. 3Sum
 * Time: O(n^2)
 * Space: O(1)
 */
class `3Sum` {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val n = nums.size
        val result = mutableListOf<List<Int>>()
        for (i in 0 until n - 1) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue
            var l = i + 1
            var r = n - 1
            while (l < r) {
                val sum = nums[l] + nums[r]
                if (nums[i] == -sum) {
                    result.add(listOf(nums[i], nums[l], nums[r]))
                    l++
                    r--
                    while (l < r && nums[l] == nums[l - 1])
                        l++
                    while (r > l && nums[r] == nums[r + 1])
                        r--
                } else if (sum > -nums[i]) {
                    r--
                } else {
                    l++
                }
            }
        }
        return result
    }
}
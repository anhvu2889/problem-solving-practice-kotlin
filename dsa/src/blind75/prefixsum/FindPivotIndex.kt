package blind75.prefixsum

/**
 * 724. Find Pivot Index
 * Time: O(n)
 * Space: O(1)
 */
class FindPivotIndex {
    fun pivotIndex(nums: IntArray): Int {
        var totalSum = 0
        var leftSum = 0
        for (num in nums) {
            totalSum += num
        }

        for (i in 0..<nums.size) {
            if (leftSum * 2 + nums[i] == totalSum)
                return i
            leftSum += nums[i]
        }
        return -1
    }
}
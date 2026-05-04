package top150.array

/**
 * 169. Majority Element
 * Time: O(n)
 * Space: O(1)
 */

class MajorityElement {
    fun majorityElement(nums: IntArray): Int {
        var count = 0
        var candidate = nums[0]
        for (num in nums) {
            if (count == 0)
                candidate = num
            if (num == candidate)
                count++
            else
                count--
        }
        return candidate
    }
}
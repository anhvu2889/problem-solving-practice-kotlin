package top150.array

/**
 * 238. Product of Array Except Self
 * Time: O(n)
 * Space: O(1)
 */
class ProductArrayExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size
        val result = IntArray(n)
        result[0] = 1
        for (i in 1 until n) {
            result[i] = result[i - 1] * nums[i - 1]
        }
        var right = 1
        for (i in n - 1 downTo 0){
            result[i] = result[i] * right
            right *= nums[i]
        }
        return result
    }
}
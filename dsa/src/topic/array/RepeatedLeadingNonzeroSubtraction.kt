package topic.array

class RepeatedLeadingNonzeroSubtraction {
    fun totalSubtracted(nums: IntArray): Long {
        val n = nums.size
        var total = 0L
        for (i in nums.indices) {
            if (nums[i] == 0) {
                continue
            }
            total += substract(nums, i, n)
        }
        return total
    }

    private fun substract(nums: IntArray, k: Int, n: Int): Int {
        val subtract = nums[k]
        var total = 0L
        for (i in k until n) {
            if (nums[i] < subtract) {
                break
            }
            nums[i] -= subtract
        }
        return subtract
    }
}
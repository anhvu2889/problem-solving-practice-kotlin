package blind75.bitmanipulation

/**
 * 136. Single Number
 * Time:
 * Space:
 */
class SingleNumber {
    fun singleNumber(nums: IntArray): Int {
        var result = 0
        for (num in nums) {
            result = result xor num
        }
        return result
    }
}
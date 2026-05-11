package topic.array

/**
 * 2553. Separate the Digits in an Array
 * Time: O(n * log(max(nums[i]))
 * Space: O(numOfDigits)
 */
class SeparateDigitsInArray {
    fun separateDigits(nums: IntArray): IntArray {
        val sb = StringBuilder()
        for (num in nums) {
            sb.append(num)
        }
        val ans = IntArray(sb.length)
        var i = 0
        for (c in sb) {
            ans[i++] = c.digitToInt()
        }
        return ans
    }
}
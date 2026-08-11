package top150.math

/**
 * 66. Plus One
 * Time: O(n)
 * Space: O(1)
 */
class PlusOne {
    fun plusOne(digits: IntArray): IntArray {
        for (i in digits.size - 1 downTo 0) {
            if (digits[i] < 9) {
                digits[i]++
                return digits
            }
            digits[i] = 0
        }
        val ans = IntArray(digits.size + 1)
        ans[0] = 1
        return ans
    }
}
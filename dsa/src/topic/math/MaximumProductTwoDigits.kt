package topic.math

/**
 * 3536. Maximum Product of Two Digits
 * Time: O(log(n))
 * Space: O(1)
 */
class MaximumProductTwoDigits {
    fun maxProduct(n: Int): Int {
        val freq = IntArray(10)
        var num = n
        while (num > 0) {
            val digit = num % 10
            freq[digit]++
            num /= 10
        }
        var product = 1
        repeat (2) {
            for (i in 9 downTo 0) {
                if (freq[i] == 0)
                    continue
                product *= i
                freq[i]--
                break
            }
        }
        return product
    }
}
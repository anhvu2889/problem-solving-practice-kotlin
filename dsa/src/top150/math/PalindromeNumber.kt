package top150.math

/**
 *  9. Palindrome Number
 *  Time: O(log(n))
 *  Space: O(1)
 */
class PalindromeNumber {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0)
            return false
        if (x % 10 == 0 && x != 0)
            return false
        var rev = 0
        var num = x
        while (rev < num) {
            val lastDigit = num % 10
            rev = rev * 10 + lastDigit
            num /= 10
        }
        return rev == num || rev / 10 == num
    }
}
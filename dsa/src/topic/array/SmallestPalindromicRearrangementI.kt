package topic.array

/**
 * 3517. Smallest Palindromic Rearrangement I
 * Time: O(n)
 * Space: O(n)
 */
class SmallestPalindromicRearrangementI {
    fun smallestPalindrome(s: String): String {
        val n = s.length
        if (n == 1)
            return s
        val freq = IntArray(26)
        for (i in 0 until n / 2) {
            val c = s[i]
            freq[c - 'a']++
        }
        val sb = StringBuilder()
        for (i in 0 until 26) {
            repeat(freq[i]) {
                sb.append('a' + i)
            }
        }
        val half = sb.toString()
        if (n % 2 == 1)
            sb.append(s[n / 2])
        return sb.append(half.reversed()).toString()
    }
}
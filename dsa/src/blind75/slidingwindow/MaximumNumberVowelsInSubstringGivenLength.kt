package blind75.slidingwindow

/**
 * 1456. Maximum Number of Vowels in a Substring of Given Length
 * Time: O(n)
 * Space: O(1)
 */
class MaximumNumberVowelsInSubstringGivenLength {
    fun maxVowels(s: String, k: Int): Int {
        var count = 0
        for (i in 0..<k) {
            if (isVowel(s[i]))
                count++
        }
        var max = count
        for (i in k..<s.length) {
            if (isVowel(s[i - k]))
                count--
            if (isVowel(s[i]))
                count++
            max = maxOf(max, count)
        }
        return max
    }

    fun isVowel(c: Char): Boolean {
        return c == 'a' || c == 'A' || c == 'E' || c == 'e' || c == 'i' || c == 'I' || c == 'u' || c == 'U' || c == 'o' || c == 'O'
    }
}
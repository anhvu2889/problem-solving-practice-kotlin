package topic.array

/**
 * 1967. Number of Strings That Appear as Substrings in Word
 * Time: O(n * m * k)
 * Space: O(1)
 */
class NumberStringsThatAppearSubstringsWord {
    fun numOfStrings(patterns: Array<String>, word: String): Int {
        var count = 0
        for (pattern in patterns) {
            if (isSubString(word, pattern)) count++
        }
        return count
    }

    private fun isSubString(word: String, pattern: String): Boolean {
        val n = word.length
        val m = pattern.length
        for (start in 0..n - m) {
            var j = 0
            while (j < m && word[start + j] == pattern[j]) {
                j++
            }
            if (j == m) return true
        }
        return false
    }
}
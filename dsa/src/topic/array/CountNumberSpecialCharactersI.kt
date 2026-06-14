package topic.array

/**
 * 3120. Count the Number of Special Characters I
 * Time: O(n)
 * Space: O(1)
 */
class CountNumberSpecialCharactersI {
    fun numberOfSpecialChars(word: String): Int {
        val freq = IntArray(64)
        for (c in word) {
            freq[c - 'A']++
        }
        var count = 0
        for (i in 0 until 32) {
            if (freq[i] > 0 && freq[i + 32] > 0)
                count++
        }
        return count
    }
}
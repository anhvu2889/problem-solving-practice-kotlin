package blind75.hashmap

/**
 * 1657. Determine if Two Strings Are Close
 * Time: O(n + m)
 * Space: O(1)
 */
class DetermineTwoStringsAreClose {
    fun closeStrings(word1: String, word2: String): Boolean {
        if (word1.length != word2.length)
            return false
        val freq1 = IntArray(26)
        val freq2 = IntArray(26)
        for (c in word1) {
            freq1[c - 'a']++
        }
        for (c in word2) {
            freq2[c - 'a']++
        }
        for (i in 0 until 26) {
            if ((freq1[i] == 0) != (freq2[i] == 0))
                return false
        }
        freq1.sort()
        freq2.sort()
        return freq1.contentEquals(freq2)
    }
}
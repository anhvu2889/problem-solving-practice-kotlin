package company.robinhood

/**
 * 1684. Count the Number of Consistent Strings
 * Time: O(n * m)
 * Space: O(1)
 */
class CountNumberConsistentStrings {
    fun countConsistentStrings(allowed: String, words: Array<String>): Int {
        var count = 0
        var freq = IntArray(26)
        for (c in allowed) {
            freq[c - 'a']++
        }
        for (word in words) {
            var valid = true
            for (c in word) {
                if (freq[c - 'a'] == 0) {
                    valid = false
                    break
                }
            }
            if (valid)
                count++
        }
        return count
    }
}
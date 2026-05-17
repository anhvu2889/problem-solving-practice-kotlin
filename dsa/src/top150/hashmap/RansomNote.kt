package top150.hashmap

/**
 * 383. Ransom Note
 * Time: O(m + n)
 * Space: O(1)
 */
class RansomNote {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val freq = IntArray(26)
        for (c in magazine) {
            freq[c - 'a']++
        }
        for (c in ransomNote) {
            freq[c - 'a']--
            if (freq[c - 'a'] < 0)
                return false
        }
        return true
    }
}
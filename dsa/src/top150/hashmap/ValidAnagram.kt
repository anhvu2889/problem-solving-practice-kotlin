package top150.hashmap

/**
 * 242. Valid Anagram
 * Time: O(n)
 * Space: O(1)
 */
class ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length)
            return false
        val freq = IntArray(26)
        for (c in s) {
            freq[c - 'a']++
        }
        for (c in t) {
            freq[c - 'a']--
        }
        for (f in freq) {
            if (f != 0)
                return false
        }
        return true
    }
}
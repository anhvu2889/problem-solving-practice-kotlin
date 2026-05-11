package topic.slidingwindow

/**
 * 567. Permutation in String
 * Time: O(n + m)
 * Space: O(1)
 */
class PermutationInString {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s2.length < s1.length)
            return false
        val need = IntArray(26)
        for (c in s1) {
            need[c - 'a']++
        }
        var missing = s1.length
        val k = s1.length
        for (r in 0 until s2.length) {
            if (need[s2[r] - 'a'] > 0) {
                missing--
            }
            need[s2[r] - 'a']--
            if (r >= k) {
                need[s2[r - k] - 'a']++
                if (need[s2[r - k] - 'a'] > 0) {
                    missing++
                }
            }
            if (missing == 0)
                return true
        }
        return false
    }
}
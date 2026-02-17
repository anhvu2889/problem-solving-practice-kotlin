package topic.twopointer

/**
 * 2486. Append Characters to String to Make Subsequence
 * Time: O(n)
 * Space: O(1)
 */
class AppendCharactersStringMakeSubsequence {
    fun appendCharacters(s: String, t: String): Int {
        var tp = 0
        var sp = 0
        while (sp < s.length && tp < t.length) {
            if (t[tp] == s[sp]) {
                tp++
            }
            sp++
        }
        return t.length - tp
    }
}
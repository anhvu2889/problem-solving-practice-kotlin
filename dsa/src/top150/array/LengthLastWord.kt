package top150.array

/**
 * 58. Length of Last Word
 * Time: O(n)
 * Space: O(1)
 */
class LengthLastWord {
    fun lengthOfLastWord(s: String): Int {
        val n = s.length
        var i = n - 1
        while ( i >= 0 && s[i] == ' '){
            i--
        }
        var length = 0
        while (i >= 0 && s[i] != ' ') {
            i--
            length++
        }
        return length
    }
}
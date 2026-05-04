package top150.array

/**
 * 151. Reverse Words in a String
 * Time: O(n)
 * Space: O(1)
 */
class ReverseWordsInString {
    fun reverseWords(s: String): String {
        val sb = StringBuilder()
        var i = s.length - 1
        while (i >= 0) {
            if (s[i] == ' ') {
                i--
                continue
            }
            val end = i
            while (i >= 0 && s[i] != ' ') {
                i--
            }
            if (sb.isNotEmpty())
                sb.append(" ")
            sb.append(s.substring(i + 1, end + 1))
        }
        return sb.toString()
    }
}
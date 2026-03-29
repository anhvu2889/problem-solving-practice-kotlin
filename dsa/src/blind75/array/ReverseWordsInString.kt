package blind75.array

/**
 * 151. Reverse Words in a String
 * Time: O(n)
 * Space: O(n)
 */
class ReverseWordsInString {
    fun reverseWords(s: String): String {
        var r = s.length - 1
        val sb = StringBuilder()
        while (r >= 0) {
            while (r >= 0 && s[r] == ' ')
                r--
            if (r < 0)
                break
            var l = r
            while (l >= 0 && s[l] != ' ')
                l--
            if (!sb.isEmpty())
                sb.append(' ')
            sb.append(s.substring(l + 1, r + 1))
            r = l
        }
        return sb.toString()
    }
}
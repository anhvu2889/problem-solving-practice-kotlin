package blind75.stack

/**
 * 2390. Removing Stars From a String
 * Time: O(n)
 * Space: O(n)
 */
class RemovingStarsFromString {
    fun removeStars(s: String): String {
        val sb = StringBuilder()
        for (c in s) {
            if (c == '*') {
                sb.deleteCharAt(sb.lastIndex)
            } else {
                sb.append(c)
            }
        }
        return sb.toString()
    }
}
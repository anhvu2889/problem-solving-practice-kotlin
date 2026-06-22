package topic.array

/**
 * 1189. Maximum Number of Balloons
 * Time: O(n)
 * Space: O(1)
 */
class MaximumNumberBalloons {
    fun maxNumberOfBalloons(text: String): Int {
        val REQUIRED_TEXT = "balloon"
        if (text.length < REQUIRED_TEXT.length)
            return 0
        val needed = IntArray(26)
        for (c in REQUIRED_TEXT) {
            needed[c - 'a']++
        }
        val input = IntArray(26)
        for (c in text) {
            input[c - 'a']++
        }
        var count = Int.MAX_VALUE
        for (i in needed.indices) {
            if (needed[i] == 0)
                continue
            if (input[i] < needed[i])
                return 0
            count = minOf(count, input[i] / needed[i])
        }
        return count
    }
}
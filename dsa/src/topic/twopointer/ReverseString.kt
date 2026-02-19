package topic.twopointer

/**
 * 344. Reverse String
 * Time: O(n)
 * Space: O(1)
 */
class ReverseString {
    fun reverseString(s: CharArray): Unit {
        var l = 0
        var r = s.size - 1
        while (l < r) {
            val temp = s[l]
            s[l] = s[r]
            s[r] = temp
            l++
            r--
        }
    }
}
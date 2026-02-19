package topic.twopointer

/**
 * 443. String Compression
 * Time: O(n)
 * Space: O(1)
 */
class StringCompression {
    fun compress(chars: CharArray): Int {
        var r = 0
        var w = 0
        while (r < chars.size) {
            var c = chars[r]
            var count = 0
            while (r < chars.size && c == chars[r]) {
                count++
                r++
            }
            chars[w++] = c
            if (count > 1) {
                for (digit in count.toString()) {
                    chars[w++] = digit
                }
            }
        }
        return w
    }
}
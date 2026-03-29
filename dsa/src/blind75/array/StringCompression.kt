package blind75.array

/**
 * 443. String Compression
 * Time: O(n)
 * Space: O(1)
 */
class StringCompression {
    fun compress(chars: CharArray): Int {
        var l = 0
        var r = 0
        while (r < chars.size) {
            val c = chars[r]
            var count = 0
            while (r < chars.size && chars[r] == c) {
                count++
                r++
            }
            chars[l] = c
            l++
            if (count <= 1)
                continue
            for (digit in count.toString()) {
                chars[l] = digit
                l++
            }
        }
        return l
    }
}
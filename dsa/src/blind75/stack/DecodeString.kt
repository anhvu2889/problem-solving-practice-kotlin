package blind75.stack

/**
 * 394. Decode String
 * Time:O(n)
 * Space: O(n)
 */
class DecodeString {
    fun decodeString(s: String): String {
        val repeatStack = ArrayDeque<Int>()
        val sbStack = ArrayDeque<StringBuilder>()
        var repeat = 0
        var sb = StringBuilder()
        for (c in s) {
            if (c.isDigit())
                repeat = repeat * 10 + (c - '0')
            else if (c == '[') {
                repeatStack.addLast(repeat)
                sbStack.addLast(sb)
                repeat = 0
                sb = StringBuilder()
            } else if (c == ']') {
                val count = repeatStack.removeLast()
                val prevSB = sbStack.removeLast()
                repeat(count) {
                    prevSB.append(sb)
                }
                sb = prevSB
            } else {
                sb.append(c)
            }
        }
        return sb.toString()
    }
}
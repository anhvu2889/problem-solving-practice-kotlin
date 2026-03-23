package topic.backtracking

/**
 * 93. Restore IP Addresses
 * Time: O(3 ^ 4)
 * Space: O(1)
 */
class RestoreIPAddresses {
    fun restoreIpAddresses(s: String): List<String> {
        var result = mutableListOf<String>()
        var parts = mutableListOf<String>()
        backtrack(s, 0, parts, result)
        return result
    }

    fun backtrack(s: String, index: Int, parts: MutableList<String>, result: MutableList<String>) {
        if (parts.size == 4) {
            if (index == s.length) {
                result.add(parts.joinToString("."))
            }
            return
        }
        val remainingParts = 4 - parts.size
        val remainingDigits = s.length - index
        if (remainingParts > remainingDigits || remainingParts * 3 < remainingDigits) {
            return
        }

        for (length in 1..3) {
            if (length + index > s.length) {
                break
            }
            val segment = s.substring(index, index + length)
            if (!isValid(segment)) {
                continue
            }
            parts.add(segment)
            backtrack(s, index + length, parts, result)
            parts.removeAt(parts.size - 1)
        }
    }

    fun isValid(segment: String): Boolean {
        if (segment.length > 1 && segment[0] == '0')
            return false
        return segment.toInt() <= 255
    }
}
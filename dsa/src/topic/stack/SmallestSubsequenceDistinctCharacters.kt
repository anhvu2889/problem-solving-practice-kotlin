package topic.stack

/**
 * 1081. Smallest Subsequence of Distinct Characters
 * Time: O(n)
 * Space: O(k)
 */
class SmallestSubsequenceDistinctCharacters {
    fun smallestSubsequence(s: String): String {
        val lastIndex = IntArray(26)
        val inStack = BooleanArray(26)
        for (i in s.indices) {
            val c = s[i]
            lastIndex[c - 'a'] = i
        }
        val stack = ArrayDeque<Char>()
        for (i in s.indices) {
            val c = s[i]
            if (inStack[c - 'a'])
                continue
            while (stack.isNotEmpty()) {
                val last = stack.last()
                if (last > c && lastIndex[last - 'a'] > i) {
                    stack.removeLast()
                    inStack[last - 'a'] = false
                } else
                    break
            }
            stack.addLast(c)
            inStack[c - 'a'] = true
        }
        return stack.joinToString("")
    }
}
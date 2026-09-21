package topic.stack

class MinimumRemoveMakeValidParentheses {
    fun minRemoveToMakeValid(s: String): String {
        val n = s.length
        val removed = BooleanArray(n)
        val openStack = ArrayDeque<Int>()
        for (i in s.indices) {
            when (s[i]) {
                '(' -> openStack.addLast(i)
                ')' -> {
                    if(openStack.isEmpty()) {
                        removed[i] = true
                    } else {
                        openStack.removeLast()
                    }
                }
            }
        }
        while (openStack.isNotEmpty()) {
            removed[openStack.removeLast()] = true
        }
        val sb = StringBuilder()
        for (i in s.indices) {
            if (removed[i]) {
                continue
            }
            sb.append(s[i])
        }
        return sb.toString()
    }
}
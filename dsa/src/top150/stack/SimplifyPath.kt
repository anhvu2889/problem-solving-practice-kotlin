package top150.stack

/**
 * 71. Simplify Path
 * Time: O(n)
 * Space: O(n)
 */
class SimplifyPath {
    fun simplifyPath(path: String): String {
        val stack = ArrayDeque<String>()
        for (part in path.split('/')) {
            if (part == "..") {
                if (stack.isNotEmpty())
                    stack.removeLast()
                continue
            }
            if (part.isEmpty() || part == ".")
                continue
            stack.addLast(part)
        }
        return "/" + stack.joinToString("/")
    }
}
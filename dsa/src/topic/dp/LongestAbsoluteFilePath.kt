package topic.dp

/**
 * 388. Longest Absolute File Path
 * Time: O(n)
 * Space: O(n)
 */
class LongestAbsoluteFilePath {
    fun lengthLongestPath(input: String): Int {
        val lines = input.split("\n")
        val pathLen = IntArray(lines.size + 1)
        var best = 0
        for (line in lines) {
            var depth = 0
            while (depth < line.length && line[depth] == '\t') {
                depth++
            }
            val name = line.substring(depth)
            if (name.contains('.')) {
                val total = pathLen[depth] + name.length
                best = maxOf(best, total)
            } else {
                pathLen[depth + 1] = pathLen[depth] + name.length + 1
            }
        }
        return best
    }
}
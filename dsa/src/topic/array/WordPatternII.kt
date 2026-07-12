package topic.array

/**
 * 291. Word Pattern II
 * Time:
 * Space: O()
 */
class WordPatternII {
    fun wordPatternMatch(pattern: String, s: String): Boolean {
        return match(0, 0, pattern, s, HashMap<Char, String>(), HashSet<String>())
    }

    private fun match(
        i: Int,
        j: Int,
        pattern: String,
        s: String,
        map: MutableMap<Char, String>,
        used: MutableSet<String>
    ): Boolean {
        if (i == pattern.length && j == s.length)
            return true
        if (i == pattern.length || j == s.length)
            return false
        if (pattern.length - i > s.length - j)
            return false
        val c = pattern[i]
        val word = map[c]
        if (word != null) {
            if (!s.startsWith(word, j))
                return false
            return match(i + 1, j + word.length, pattern, s, map, used)
        }
        for (end in j + 1..s.length) {
            val word = s.substring(j, end)
            if (word in used)
                continue
            used.add(word)
            map[c] = word
            if (match(i + 1, end, pattern, s, map, used))
                return true
            used.remove(word)
            map.remove(c)
        }
        return false
    }
}
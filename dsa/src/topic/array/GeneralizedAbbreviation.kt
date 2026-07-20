package topic.array

/**
 * 320. Generalized Abbreviation
 * Time: O(n * 2 ^ n)
 * Space: O(n * 2 ^ n)
 */
class GeneralizedAbbreviation {
    fun generateAbbreviations(word: String): List<String> {
        val result = mutableListOf<String>()
        backtrack(word, 0, StringBuilder(), 0, result)
        return result
    }

    private fun backtrack(word: String, pos: Int, current: StringBuilder, count: Int, result: MutableList<String>) {
        if (pos == word.length) {
            val savedLength = current.length
            if (count > 0) current.append(count)
            result.add(current.toString())
            current.setLength(savedLength)
            return
        }
        backtrack(word, pos + 1, current, count + 1, result)
        val savedLength = current.length
        if (count > 0) current.append(count)
        current.append(word[pos])
        backtrack(word, pos + 1, current, 0, result)
        current.setLength(savedLength)
    }
}
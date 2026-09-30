package topic.hashmap

/**
 * 1807. Evaluate the Bracket Pairs of a String
 * Time: O(m + n)
 * Space: O(m + n)
 */
class EvaluateBracketPairsString {
    fun evaluate(s: String, knowledge: List<List<String>>): String {
        val dict = buildDict(knowledge)
        return buildString(s, dict)
    }

    private fun search(key: String, dict: Map<String, String>): String {
        return dict[key] ?: "?"
    }

    private fun buildString(s: String, dict: Map<String, String>): String {
        val ans = StringBuilder()
        var keySb = StringBuilder()
        var inBracket = false
        for (c in s) {
            when (c) {
                '(' -> {
                    keySb.clear()
                    inBracket = true
                }

                ')' -> {
                    ans.append(search(keySb.toString(), dict))
                    inBracket = false
                }

                else -> {
                    if (inBracket) {
                        keySb.append(c)
                    } else {
                        ans.append(c)
                    }
                }
            }
        }
        return ans.toString()
    }

    private fun buildDict(knowledge: List<List<String>>): Map<String, String> {
        val map = HashMap<String, String>()
        for (pair in knowledge) {
            val key = pair[0]
            val value = pair[1]
            map[key] = value
        }
        return map
    }
}
package topic.trie

/**
 * 472. Concatenated Words
 * Time: O(n * l ^ 3)
 * Space: O(n * l)
 */
class ConcatenatedWords {
    fun findAllConcatenatedWordsInADict(words: Array<String>): List<String> {
        val dict = words.toHashSet()
        val ans = mutableListOf<String>()
        for (word in words) {
            if (word.isEmpty()) {
                continue
            }
            dict.remove(word)
            if (canConcat(word, dict)) {
                ans.add(word)
            }
            dict.add(word)
        }
        return ans
    }

    private fun canConcat(s: String, dict: Set<String>): Boolean {
        val n = s.length
        val dp = BooleanArray(n + 1)
        dp[0] = true
        for (i in 1..n) {
            for (j in 0 until i) {
                if(dp[j] && s.substring(j, i) in dict) {
                    dp[i] = true
                    break
                }
            }
        }
        return dp[n]
    }
}
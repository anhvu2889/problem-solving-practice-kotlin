package topic.trie

/**
 * 140. Word Break II
 * Time: O(2 ^ n)
 * Space: O(2 ^ n)
 */
class WordBreakII {
    private class Node {
        val children = arrayOfNulls<Node>(26)
        var endWord = false
    }

    private val root = Node()

    private fun insert(s: String) {
        var node = root
        for (c in s) {
            val i = c - 'a'
            if (node.children[i] == null) {
                node.children[i] = Node()
            }
            node = node.children[i]!!
        }
        node.endWord = true
    }

    private fun buildTrie(wordDict: List<String>) {
        for (word in wordDict) {
            insert(word)
        }
    }

    private fun buildSentence(s: String, start: Int, memo: HashMap<Int, List<String>>): List<String> {
        if (start == s.length) {
            return listOf("")
        }
        memo[start]?.let {
            return it
        }
        val ans = mutableListOf<String>()
        var node = root
        var end = start
        while (end < s.length) {
            val i = s[end] - 'a'
            if (node.children[i] == null) {
                break
            }
            node = node.children[i]!!
            end++
            if (node.endWord) {
                val word = s.substring(start, end)
                for (next in buildSentence(s, end, memo)) {
                    if (next.isEmpty()) {
                        ans.add(word)
                    } else {
                        ans.add("$word $next")
                    }
                }
            }


        }
        memo[start] = ans
        return ans
    }

    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        buildTrie(wordDict)
        val memo = HashMap<Int, List<String>>()
        return buildSentence(s, 0, memo)
    }
}
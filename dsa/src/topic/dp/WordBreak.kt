package topic.dp

/**
 * 139. Word Break
 * Time: O(n ^ 2 + m * L)
 * Space: O(m * L)
 */
class WordBreak {

    private class TrieNode {
        val children = arrayOfNulls<TrieNode>(26)
        var endWord = false
    }

    private fun insert(root: TrieNode, word: String) {
        var node = root
        for (c in word) {
            val i = c - 'a'
            if (node.children[i] == null) {
                node.children[i] = TrieNode()
            }
            node = node.children[i]!!
        }
        node.endWord = true
    }

    private fun buildTrie(words: List<String>): TrieNode {
        val root = TrieNode()
        for (word in words) {
            insert(root, word)
        }
        return root
    }

    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val root = buildTrie(wordDict)
        val n = s.length
        val canBreakFrom = BooleanArray(n + 1)
        canBreakFrom[n] = true
        for (start in n - 1 downTo 0) {
            var node = root
            for (end in start until n) {
                val i = s[end] - 'a'
                node = node.children[i] ?: break
                if (node.endWord && canBreakFrom[end + 1]) {
                    canBreakFrom[start] = true
                    break
                }
            }
        }
        return canBreakFrom[0]
    }
}
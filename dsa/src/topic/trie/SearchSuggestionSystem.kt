package topic.trie

/**
 * 1268. Search Suggestions System
 * Time: O(mlog(m) + l + n)
 * Space: O(m + l + n)
 */
class SearchSuggestionSystem {
    private class Node {
        val children = arrayOfNulls<Node>(26)
        var isEnd = false
        val words = mutableListOf<String>()
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
            if (node.words.size < 3) {
                node.words.add(s)
            }
        }
        node.isEnd = true
    }

    fun suggestedProducts(products: Array<String>, searchWord: String): List<List<String>> {
        val sorted = products.sorted()
        for (product in sorted) {
            insert(product)
        }
        val ans = mutableListOf<List<String>>()
        var node = root
        for (c in searchWord) {
            val i = c - 'a'
            if (node.children[i] == null) {
                break
            }
            node = node.children[i]!!
            ans.add(node.words)
        }
        while (ans.size < searchWord.length) {
            ans.add(listOf())
        }
        return ans
    }
}
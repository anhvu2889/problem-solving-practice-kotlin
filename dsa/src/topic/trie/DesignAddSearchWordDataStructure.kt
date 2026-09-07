package topic.trie

/**
 * 211. Design Add and Search Words Data Structure
 */
class DesignAddSearchWordDataStructure {
    private class Node {
        val children = arrayOfNulls<Node>(26)
        var isEnd = false
    }

    private val root = Node()

    private fun findNode(s: String): Node? {
        var node = root
        for (c in s) {
            val i = c - 'a'
            if (node.children[i] == null) {
                return null
            }
            node = node.children[i]!!
        }
        return node
    }

    private fun dfs(node: Node, word: String, i: Int): Boolean {
        if (i == word.length) {
            return node.isEnd
        }
        val c = word[i]
        if (c == '.') {
            for (child in node.children) {
                if (child != null && dfs(child, word, i + 1)) {
                    return true
                }
            }
            return false
        }
        val child = node.children[c - 'a']
        if (child == null) {
            return false
        }
        return dfs(child, word, i + 1)
    }

    fun addWord(word: String) {
        var node = root
        for (c in word) {
            val i = c - 'a'
            if (node.children[i] == null) {
                node.children[i] = Node()
            }
            node = node.children[i]!!
        }
        node.isEnd = true
    }

    fun search(word: String): Boolean {
        return dfs(root, word, 0)
    }
}
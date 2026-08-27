package top150.graph

/**
 * 127. Word Ladder
 * Time: O(n ^ 2 * k)
 * Space: O(k)
 */
class WordLadder {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val wordSet = wordList.toHashSet()
        val queue = ArrayDeque<String>()
        val visited = HashSet<String>()
        visited.add(beginWord)
        queue.addLast(beginWord)
        var steps = 0
        while (queue.isNotEmpty()) {
            val size = queue.size
            steps++
            repeat(size) {
                val cur = queue.removeFirst()
                val adjNodes = getAdjNodes(cur, wordSet)
                for (node in adjNodes) {
                    if (node == endWord) {
                        return steps
                    }
                    if (visited.add(node)) {
                        queue.addLast(node)
                    }
                }
            }
        }
        return 0
    }

    private fun getAdjNodes(src: String, wordSet: HashSet<String>): List<String> {
        val sb = StringBuilder(src)
        val ans = mutableListOf<String>()
        for (i in sb.indices) {
            val curChar = sb[i]
            for (c in 'a'..'z') {
                if (curChar == c) {
                    continue
                }
                sb[i] = c
                val mutation = sb.toString()
                if (mutation in wordSet) {
                    ans.add(mutation)
                }
            }
            sb[i] = curChar
        }
        return ans
    }
}
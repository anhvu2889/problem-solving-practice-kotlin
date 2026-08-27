package top150.graph

/**
 * 126. Word Ladder II
 * Time: O(n * L^ 2 + P * D)
 * Space: O( n * L + P)
 */
class WordLadderII {
    fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
        val wordSet = wordList.toHashSet()
        if (endWord !in wordSet) {
            return listOf()
        }
        val queue = ArrayDeque<String>()
        val parents = HashMap<String, MutableList<String>>()
        queue.addLast(beginWord)
        var found = false
        while (queue.isNotEmpty() && !found) {
            val visited = HashSet<String>()
            val size = queue.size
            repeat(size) {
                val cur = queue.removeFirst()
                val neighbors = getNeighbors(cur, wordSet)
                for (neighbor in neighbors) {
                    parents.getOrPut(neighbor) { mutableListOf<String>() }.add(cur)
                    if (!visited.add(neighbor)) {
                        continue
                    }
                    if (neighbor == endWord) {
                        found = true
                    } else {
                        queue.addLast(neighbor)
                    }
                }
            }
            wordSet.removeAll(visited)
        }
        return if (found) getPath(beginWord, endWord, parents) else listOf()
    }

    private fun getNeighbors(src: String, wordSet: Set<String>): List<String> {
        val sb = StringBuilder(src)
        val ans = mutableListOf<String>()
        for (i in sb.indices) {
            val cur = sb[i]
            for (c in 'a'..'z') {
                if (cur == c) {
                    continue
                }
                sb[i] = c
                val mutation = sb.toString()
                if (mutation in wordSet) {
                    ans.add(mutation)
                }
            }
            sb[i] = cur
        }
        return ans
    }

    private fun getPath(start: String, end: String, parents: Map<String, MutableList<String>>): List<List<String>> {
        val ans = mutableListOf<List<String>>()
        val queue = ArrayDeque<List<String>>()
        queue.addLast(listOf(end))
        while (queue.isNotEmpty()) {
            val path = queue.removeFirst()
            val last = path.last()
            if (last == start) {
                ans.add(path.reversed())
                continue
            }
            for (src in parents.getValue(last)) {
                queue.addLast(path + src)
            }
        }
        return ans
    }
}
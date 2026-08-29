package topic.topologicalsort

/**
 * 269. Alien Dictionary
 * Time: O(C)
 * Space: O(1)
 */
class AlienDictionary {
    fun alienOrder(words: Array<String>): String {
        val graph = Array(26) { HashSet<Int>() }
        val indeg = IntArray(26)
        val present = checkPresent(words)
        if (!buildGraph(words, graph, indeg)) {
            return ""
        }
        return kahn(graph, indeg, present)
    }

    private fun checkPresent(words: Array<String>): BooleanArray {
        val present = BooleanArray(26)
        for (word in words) {
            for (c in word) {
                present[c - 'a'] = true
            }
        }
        return present
    }

    private fun buildGraph(words: Array<String>, graph: Array<HashSet<Int>>, indeg: IntArray): Boolean {
        for (i in 1 until words.size) {
            val s1 = words[i - 1]
            val s2 = words[i]
            val minLen = minOf(s1.length, s2.length)
            var j = 0
            while (j < minLen) {
                if (s1[j] == s2[j]) {
                    j++
                    continue
                }
                val c1 = s1[j] - 'a'
                val c2 = s2[j] - 'a'
                if (graph[c1].add(c2)) {
                    indeg[c2]++
                }
                break
            }
            if (j == minLen && s1.length > s2.length) {
                return false
            }
        }
        return true
    }

    private fun kahn(graph: Array<HashSet<Int>>, indeg: IntArray, present: BooleanArray): String {
        val sb = StringBuilder()
        val queue = ArrayDeque<Int>()
        for (i in indeg.indices) {
            if (!present[i]) {
                continue
            }
            if (indeg[i] == 0) {
                queue.addLast(i)
            }
        }

        var total = 0
        for (p in present) {
            if (p) {
                total++
            }
        }

        while (queue.isNotEmpty()) {
            val cur = queue.removeFirst()
            val c = 'a' + cur
            sb.append(c)
            val adjNodes = graph[cur]
            for (nb in adjNodes) {
                indeg[nb]--
                if (indeg[nb] == 0) {
                    queue.addLast(nb)
                }
            }
        }
        return if (sb.length == total) sb.toString() else ""
    }
}
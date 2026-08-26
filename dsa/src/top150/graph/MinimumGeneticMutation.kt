package top150.graph

/**
 * 433. Minimum Genetic Mutation
 * Time: O(n)
 * Space: O(n)
 */
class MinimumGeneticMutation {
    fun minMutation(startGene: String, endGene: String, bank: Array<String>): Int {
        val bankSet = bank.toHashSet()
        if (endGene !in bankSet)
            return -1
        val queue = ArrayDeque<String>()
        val visited = HashSet<String>()
        val chars = charArrayOf('A', 'C', 'G', 'T')
        var steps = 0
        queue.addLast(startGene)
        visited.add(startGene)
        while (queue.isNotEmpty()) {
            val size = queue.size
            steps++
            repeat(size) {
                val cur = queue.removeFirst()
                val adjNodes = getAdjNodes(cur, bankSet, chars)
                for (node in adjNodes) {
                    if (node == endGene) {
                        return steps
                    }
                    if (visited.add(node)) {
                        queue.addLast(node)
                    }
                }
            }
        }
        return -1
    }

    private fun getAdjNodes(src: String, bankSet: HashSet<String>, chars: CharArray): List<String> {
        val ans = mutableListOf<String>()
        val sb = StringBuilder(src)
        for (i in src.indices) {
            val cur = src[i]
            for (c in chars) {
                if (cur == c) {
                    continue
                }
                sb[i] = c
                val mutation = sb.toString()
                if (mutation in bankSet) {
                    ans.add(mutation)
                }
            }
            sb[i] = cur
        }
        return ans
    }
}
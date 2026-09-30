package topic.heap

import java.util.*

/**
 * 692. Top K Frequent Words
 * Time: O(nlog(n))
 * Space: O(k)
 */
class TopKFrequentWords {
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val freqMap = buildFreqMap(words)
        return getTopKFreq(freqMap, k)
    }

    private fun getTopKFreq(freqMap: Map<String, Int>, k: Int): List<String> {
        val minHeap =
            PriorityQueue<Pair<String, Int>>(compareBy<Pair<String, Int>> { it.second }.thenByDescending { it.first })
        for ((word, count) in freqMap) {
            minHeap.add(Pair(word, count))
            if (minHeap.size > k) {
                minHeap.poll()
            }
        }
        val ans = mutableListOf<String>()
        while (minHeap.isNotEmpty()) {
            ans.add(minHeap.poll().first)
        }
        return ans.reversed()
    }

    private fun buildFreqMap(words: Array<String>): Map<String, Int> {
        val freqMap = HashMap<String, Int>()
        for (word in words) {
            val freq = freqMap.getOrDefault(word, 0) + 1
            freqMap[word] = freq
        }
        return freqMap
    }
}
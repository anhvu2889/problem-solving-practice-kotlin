package topic.hashmap

class ProductQualityContiguousBlocks {
    fun minCost(quality: IntArray): Int {
        val lastSeen = HashMap<Int, Int>()
        val freq = HashMap<Int, Int>()
        scan(quality, lastSeen, freq)
        return quality.size - countSaved(quality, lastSeen, freq)
    }

    private fun scan(quality: IntArray, lastSeen: HashMap<Int, Int>, freq: HashMap<Int, Int>)  {
        for (i in quality.indices) {
            val num = quality[i]
            lastSeen[num] = i
            freq[num] = freq.getOrDefault(num, 0) + 1
        }
    }

    private fun countSaved(quality: IntArray, lastSeen: HashMap<Int, Int>, freq: HashMap<Int, Int>): Int {
        var saved = 0
        var bestFreq = 0
        var end = 0
        for (i in quality.indices) {
            val num = quality[i]
            end = maxOf(end, lastSeen[num]!!)
            bestFreq = maxOf(bestFreq, freq[num]!!)
            if (i == end) {
                saved += bestFreq
                bestFreq = 0
            }
        }
        return saved
    }
}
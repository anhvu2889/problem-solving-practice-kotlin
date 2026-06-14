package topic.array

/**
 * 3838. Weighted Word Mapping
 * Time: O(m * n)
 * Space: O(m)
 */
class WeightedWordMapping {
    fun mapWordWeights(words: Array<String>, weights: IntArray): String {
        val sb = StringBuilder()
        for (word in words) {
            var sum = 0
            for (c in word) {
                sum += weights[c - 'a']
            }
            val code = 'z'.code - (sum % 26)
            sb.append(Char(code))
        }
        return sb.toString()
    }
}
package blind75.array

/**
 * 1768. Merge Strings Alternately
 */
class MergeStringsAlternately {
    fun mergeAlternately(word1: String, word2: String): String {
        val sb = StringBuilder()
        val minLength = minOf(word1.length, word2.length)
        for (i in 0..<minLength) {
            sb.append(word1[i])
            sb.append(word2[i])
        }
        if (word1.length > minLength) {
            sb.append(word1.substring(minLength))
        }
        if (word2.length > minLength) {
            sb.append(word2.substring(minLength))
        }
        return sb.toString()
    }
}
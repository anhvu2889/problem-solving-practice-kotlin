package topic.array

/**
 * 3121. Count the Number of Special Characters II
 * Time: O(n)
 * Space: O(1)
 */
class CountNumberSpecialCharactersII {
    fun numberOfSpecialChars(word: String): Int {
        val seen = IntArray(64) {-1}
        for (i in word.indices) {
            val pos = word[i] - 'A'
            if (pos >= 32) {
                seen[pos] = i
            } else if (seen[pos] == -1){
                seen[pos] = i
            }
        }
        var count = 0
        for (pos in 0 until 32) {
            if (seen[pos] > seen[pos + 32] && seen[pos + 32] > -1)
                count++
        }
        return count
    }
}
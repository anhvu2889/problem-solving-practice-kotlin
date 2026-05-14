package topic.slidingwindow

/**
 * 30. Substring with Concatenation of All Words
 * Time: O(n)
 * Space: O(m * k)
 */
class SubstringConcatenationAllWords {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val ans = mutableListOf<Int>()
        if (words.isEmpty()) return ans
        val wordLength = words[0].length
        val wordCount = words.size
        val totalLength = wordLength * wordCount
        val n = s.length
        if (n < totalLength) return ans
        val need = HashMap<String, Int>()
        for (word in words) {
            need[word] = need.getOrDefault(word, 0) + 1
        }
        for (offset in 0 until wordLength) {
            val window = HashMap<String, Int>()
            var left = offset
            var count = 0
            var right = offset
            while (right + wordLength <= n) {
                val word = s.substring(right, right + wordLength)
                if (word !in need) {
                    window.clear()
                    count = 0
                    left = right + wordLength
                    right += wordLength
                    continue
                }
                window[word] = window.getOrDefault(word, 0) + 1
                count++
                while (window.getOrDefault(word, 0) > need.getOrDefault(word, 0)) {
                    val leftWord = s.substring(left, left + wordLength)
                    val freq = window.getOrDefault(leftWord, 0)
                    if (freq == 1) {
                        window.remove(leftWord)
                    } else {
                        window[leftWord] = freq - 1
                    }
                    count--
                    left += wordLength
                }
                if (count == wordCount) {
                    ans.add(left)
                    val leftWord = s.substring(left, left + wordLength)
                    val freq = window.getOrDefault(leftWord, 0)
                    if (freq == 1) {
                        window.remove(leftWord)
                    } else {
                        window[leftWord] = freq - 1
                    }
                    count--
                    left += wordLength
                }
                right += wordLength
            }
        }
        return ans
    }
}
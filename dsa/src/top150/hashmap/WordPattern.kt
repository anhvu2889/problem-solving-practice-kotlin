package top150.hashmap

/**
 * 290. Word Pattern
 * Time: O(n)
 * Space: O(1)
 */
class WordPattern {
    fun wordPattern(pattern: String, s: String): Boolean {
        val words = s.split(' ')
        if (words.size != pattern.length)
            return false
        val charMap = HashMap<Char, String>()
        val wordMap = HashMap<String, Char>()
        for (i in words.indices) {
            val char = pattern[i]
            val word = words[i]
            if (charMap.containsKey(char) && charMap[char] != word)
                return false
            if (wordMap.containsKey(word) && wordMap[word] != char)
                return false
            charMap[char] = word
            wordMap[word] = char
        }
        return true
    }
}
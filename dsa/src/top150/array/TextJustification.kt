package top150.array

/**
 * 68. Text Justification
 * Time: O(n)
 * Space: O(n)
 */
class TextJustification {
    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        val result = mutableListOf<String>()
        var i = 0

        while (i < words.size) {
            var wordLenSum = 0
            var j = i

            while (j < words.size && wordLenSum + words[j].length + (j - i) <= maxWidth) {
                wordLenSum += words[j].length
                j++
            }

            val count = j - i
            val isLastLine = j == words.size
            val line = StringBuilder()

            if (isLastLine || count == 1) {
                for (idx in i until j) {
                    if (idx > i) line.append(' ')
                    line.append(words[idx])
                }

                while (line.length < maxWidth) {
                    line.append(' ')
                }
            } else {
                val gaps = count - 1
                val totalSpaces = maxWidth - wordLenSum
                val baseSpace = totalSpaces / gaps
                val extra = totalSpaces % gaps

                for (idx in i until j) {
                    line.append(words[idx])

                    if (idx < j - 1) {
                        val gapIndex = idx - i
                        val spaces = baseSpace + if (gapIndex < extra) 1 else 0

                        repeat(spaces) {
                            line.append(' ')
                        }
                    }
                }
            }

            result.add(line.toString())
            i = j
        }

        return result
    }
}
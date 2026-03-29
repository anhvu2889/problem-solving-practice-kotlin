package blind75.array

/**
 * 345. Reverse Vowels of a String
 * Time: O(n)
 * Space: O(1)
 */
class ReverseVowelsString {
    fun reverseVowels(s: String): String {
        var a = s.toCharArray()
        var l = 0
        var r = s.length - 1
        while (l < r) {
            while (l < r && !isVowel(a[l]))
                l++
            while (l < r && !isVowel(a[r]))
                r--
            val temp = a[l]
            a[l] = a[r]
            a[r] = temp
            l++
            r--
        }
        return String(a)
    }

    private fun isVowel(char: Char): Boolean {
        return char == 'a' || char == 'e' || char == 'i' || char == 'o' || char == 'u' ||
                char == 'A' || char == 'E' || char == 'I' || char == 'O' || char == 'U'
    }
}
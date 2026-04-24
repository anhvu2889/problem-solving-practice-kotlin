package blind75.backtracking

/**
 * 17. Letter Combinations of a Phone Number
 * Time: O(4 ^ n)
 * Space: O(n)
 */
class LetterCombinationsPhoneNumber {
    private val map = arrayOf("", "", "abc", "def", "ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz")

    fun letterCombinations(digits: String): List<String> {
        val result = mutableListOf<String>()
        val path = StringBuilder()
        backtrack(digits, 0, path, result)
        return result
    }

    fun backtrack(digits: String, index: Int, path: StringBuilder, result: MutableList<String>) {
        if (path.length == digits.length) {
            result.add(path.toString())
            return
        }
        val letters = map[digits[index] - '0']
        for (letter in letters) {
            path.append(letter)
            backtrack(digits, index + 1, path, result)
            path.deleteCharAt(path.lastIndex)
        }
    }
}
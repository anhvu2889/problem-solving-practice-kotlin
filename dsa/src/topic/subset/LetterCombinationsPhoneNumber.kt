package topic.subset

/**
 * 17. Letter Combinations of a Phone Number
 * Time: O(n x 4^n)
 * Space: O(n x 4^n)
 */
class LetterCombinationsPhoneNumber {

    private val map = arrayOf(
        "", "", "abc", "def", "ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz"
    )

    fun letterCombinations(digits: String): List<String> {
        var result = mutableListOf<String>()
        if (digits.length == 0)
            return result
        var path = StringBuilder()
        backtrack(digits, 0, path, result)
        return result
    }
    fun backtrack(digits: String, index: Int, path: StringBuilder, result: MutableList<String>) {
        if (path.length == digits.length) {
            result.add(path.toString())
            return
        }
        val letters = map[digits[index] - '0']
        for (char in letters) {
            path.append(char)
            backtrack(digits, index + 1, path, result)
            path.deleteCharAt(path.length - 1)
        }
    }
}
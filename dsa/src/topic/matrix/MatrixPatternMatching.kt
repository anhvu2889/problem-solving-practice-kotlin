package topic.matrix

class MatrixPatternMatching {
    fun containsPattern(matrix: Array<IntArray>, pattern: Array<CharArray>): Boolean {
        val m = matrix.size
        val n = matrix[0].size
        val patternHeight = pattern.size
        val patternWidth = pattern[0].size
        if (m < patternHeight || n < patternWidth) {
            return false
        }
        for (r in 0..m - patternHeight) {
            for (c in 0..n - patternWidth) {
                if (isMatch(matrix, pattern, r, c)) {
                    return true
                }
            }
        }

        return false
    }

    private fun isMatch(matrix: Array<IntArray>, pattern: Array<CharArray>, top: Int, left: Int): Boolean {
        val charToValue = HashMap<Char, Int>()
        val m = pattern.size
        val n = pattern[0].size
        for (r in 0 until m) {
            for (c in 0 until n) {
                val char = pattern[r][c]
                val value = matrix[top + r][left + c]
                if (charToValue[char] == null) {
                    charToValue[char] = value
                } else {
                    if (charToValue[char] != value) {
                        return false
                    }
                }
            }
        }
        return true
    }
}
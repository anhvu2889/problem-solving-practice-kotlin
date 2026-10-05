package topic.dp

class MatrixExpressionMaxValue {

    private val INF = Int.MIN_VALUE / 2

    fun maxExpression(grid: Array<CharArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val dig = Array(m) { IntArray(n) { INF } }
        val plus = Array(m) { IntArray(n) { INF } }
        val minus = Array(m) { IntArray(n) { INF } }

        for (r in 0 until m) {
            for (c in 0 until n) {
                val char = grid[r][c]
                if (char.isDigit()) {
                    dig[r][c] = findMaxDigit(grid, plus, minus, r, c)
                } else {
                    val upDig = if (r > 0) dig[r - 1][c] else INF
                    val leftDig = if (c > 0) dig[r][c - 1] else INF
                    val max = maxOf(upDig, leftDig)
                    if (char == '+') {
                        plus[r][c] = max
                    } else {
                        minus[r][c] = max
                    }
                }
            }
        }
        return scanMax(dig, m, n)
    }

    private fun scanMax(dig: Array<IntArray>, m: Int, n: Int): Int {
        var max = Int.MIN_VALUE
        for (r in 0 until m) {
            for (c in 0 until n) {
                max = maxOf(max, dig[r][c])
            }
        }
        return max
    }

    private fun findMaxDigit(grid: Array<CharArray>, plus: Array<IntArray>, minus: Array<IntArray>, r: Int, c: Int): Int {
        val digit = grid[r][c] - '0'

        val plusUp = if (r > 0) plus[r - 1][c] else INF
        val plusLeft = if (c > 0) plus[r][c - 1] else INF
        val maxPlus = maxOf(plusUp, plusLeft)

        val minusUp = if (r > 0) minus[r - 1][c] else INF
        val minusLeft = if (c > 0) minus[r][c - 1] else INF
        val maxMinus = maxOf(minusUp, minusLeft)

        var max = digit
        if (maxPlus != INF) {
            max = maxOf(max, maxPlus + digit)
        }
        if (maxMinus != INF) {
            max = maxOf(max, maxMinus - digit)
        }

        return max
    }
}
package top150.array

/**
 * 6. Zigzag Conversion
 * Time:
 * Space:
 */
class ZigzagConversion {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1 || numRows >= s.length)
            return s
        val grid = Array(numRows) { StringBuilder() }
        var down = true
        var row = 0
        for (c in s) {
            grid[row].append(c)
            if (down) {
                row++
            } else {
                row--
            }
            if (row == 0) {
                down = true
            }
            if (row == numRows - 1) {
                down = false
            }
        }
        val sb = StringBuilder()
        for (line in grid) {
            sb.append(line)
        }
        return sb.toString()
    }
}
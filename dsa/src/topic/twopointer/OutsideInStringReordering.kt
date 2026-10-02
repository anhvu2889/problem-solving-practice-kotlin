package topic.twopointer

class OutsideInStringReordering {
    fun reorder(s: String): String {
        var l = 0
        var r = s.length - 1
        val sb = StringBuilder()
        while (l < r) {
            sb.append(s[l])
            sb.append(s[r])
            l++
            r--
        }
        if (l == r) {
            sb.append(l)
        }
        return sb.toString()
    }
}
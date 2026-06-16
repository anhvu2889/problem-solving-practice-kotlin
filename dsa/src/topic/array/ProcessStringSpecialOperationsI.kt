package topic.array

/**
 * 3612. Process String with Special Operations I
 * Time:
 * Space:
 */
class ProcessStringSpecialOperationsI {
    fun processStr(s: String): String {
        val sb = StringBuilder()
        for (c in s) {
            when (c) {
                in 'a'..'z' -> {
                    sb.append(c)
                }

                '*' -> {
                    if (sb.isNotEmpty())
                        sb.deleteCharAt(sb.lastIndex)
                }

                '#' -> {
                    val clone = sb.toString()
                    sb.append(clone)
                }

                '%' -> {
                    sb.reverse()
                }
            }
        }
        return sb.toString()
    }
}
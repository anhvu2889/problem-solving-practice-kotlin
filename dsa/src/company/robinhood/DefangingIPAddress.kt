package company.robinhood

/**
 * 1108. Defanging an IP Address
 * Time: O(n)
 * Space: O(n)
 */
class DefangingIPAddress {
    fun defangIPaddr(address: String): String {
        val sb = StringBuilder()
        for (c in address) {
            when (c) {
                '.' -> sb.append("[.]")
                else -> sb.append(c)
            }
        }
        return sb.toString()
    }
}
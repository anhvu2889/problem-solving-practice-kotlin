package topic.greedy

/**
 * 1541. Minimum Insertions to Balance a Parentheses String
 * Time: O(n)
 * Space: O(1)
 */
class MinimumInsertionsBalanceParenthesesString {
    fun minInsertions(s: String): Int {
        var balance = 0
        var insert = 0
        for (c in s) {
            when (c) {
                '(' -> {
                    if (balance % 2 == 1) {
                        balance--
                        insert++
                    }
                    balance += 2
                }

                else -> {
                    if (balance == 0) {
                        balance += 2
                        insert++
                    }
                    balance--
                }
            }
        }
        insert += balance
        return insert
    }
}
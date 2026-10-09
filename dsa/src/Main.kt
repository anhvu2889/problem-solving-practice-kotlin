import topic.graph.dijkstra.MinimumCostsUsingTrainLine
import topic.greedy.MinimumInsertionsBalanceParenthesesString

fun main() {
    val regular = intArrayOf(1, 6, 9, 5)
    val express = intArrayOf(5, 2, 3, 10)
    val expressCost = 8
    val s = "))(()()))()))))))()())()(())()))))()())(()())))()("
    val result = MinimumInsertionsBalanceParenthesesString().minInsertions(s)
    print(result)
}
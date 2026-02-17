import topic.twopointer.AppendCharactersStringMakeSubsequence
import topic.twopointer.SquaresOfSortedArray

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var nums1 = intArrayOf(-4, -1, 0, 3, 10)
    var nums2 = intArrayOf(-7, -3, 2, 3, 11)
    var nums3 = intArrayOf(7, 6, 4, 3, 1)
    var s = "z"
    var t = "abcde"
    val result = SquaresOfSortedArray().sortedSquares(nums2)
    println(result.contentToString())
}
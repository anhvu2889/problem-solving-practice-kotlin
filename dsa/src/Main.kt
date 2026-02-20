import topic.twopointer.NextPermutation
import topic.twopointer.PartitionLabel
import topic.twopointer.ReverseString
import topic.twopointer.StringCompression

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var nums1 = intArrayOf(-4, -1, 0, 3, 10)
    var nums2 = intArrayOf(-7, -3, 2, 3, 11)
    var nums3 = intArrayOf(7, 6, 4, 3, 1)
    var s1 = charArrayOf('h', 'e', 'l', 'l', 'o')
    var chars = charArrayOf('a', 'a', 'b', 'b', 'c', 'c', 'c')
    var s = "ababcbacadefegdehijhklij"
    var t = "abcde"
    val result = NextPermutation().nextPermutation(nums1)
    println(nums1.contentToString())
}
import topic.array.ConfusingNumber
import topic.twopointer.PartitionArrayAccordingGivenPivot
import topic.twopointer.SortColor

fun main() {
    var nums1 = intArrayOf(9,12,5,10,14,3,10)
    var nums2 = intArrayOf(-7, -3, 2, 3, 11)
    var nums3 = intArrayOf(4, 1, 2, 2, 9, 7, 3)
    var s1 = charArrayOf('h', 'e', 'l', 'l', 'o')
    var chars = charArrayOf('a', 'a', 'b', 'b', 'c', 'c', 'c')
    var s = "ababcbacadefegdehijhklij"
    var t = "abcde"
    val result = PartitionArrayAccordingGivenPivot().pivotArray(nums1, 10)
    println(result)

}
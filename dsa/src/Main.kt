import topic.twopointer.SortColor

fun main() {
    var nums1 = intArrayOf(1, 2, 0)
    var nums2 = intArrayOf(-7, -3, 2, 3, 11)
    var nums3 = intArrayOf(4, 1, 2, 2, 9, 7, 3)
    var s1 = charArrayOf('h', 'e', 'l', 'l', 'o')
    var chars = charArrayOf('a', 'a', 'b', 'b', 'c', 'c', 'c')
    var s = "ababcbacadefegdehijhklij"
    var t = "abcde"
    val result = SortColor().sortColors(nums1)
    println(nums1.contentToString())
}
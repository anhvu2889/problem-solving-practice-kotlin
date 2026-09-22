import topic.array.ConfusingNumber
import topic.dp.LongestAbsoluteFilePath
import topic.hashmap.HighFive
import topic.math.CountCommasRangeII
import topic.math.GCDOddEvenSums
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
    val input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
    val result = LongestAbsoluteFilePath().lengthLongestPath(input)
    println(result)
    for (day in 30 downTo 0) {
        println("Count down in: $day days")
    }

    fun largestNumber(nums: IntArray): String {
        val strs = mutableListOf<String>()
        for (num in nums) {
            strs.add(num.toString())
        }
        strs.sortWith(Comparator() {a, b -> b.compareTo(a)})
        val sb = StringBuilder()
        for (s in strs) {
            sb.append(s)
        }
        return sb.toString()
    }
}
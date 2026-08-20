package topic.array

/**
 * 3069. Distribute Elements Into Two Arrays I
 * Time: O(n)
 * Space: O(n)
 */
class DistributeElementsIntoTwoArraysI {
    fun resultArray(nums: IntArray): IntArray {
        val n = nums.size
        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()
        list1.add(nums[0])
        list2.add(nums[1])
        for (i in 2..<n) {
            if (list1.last() > list2.last()) {
                list1.add(nums[i])
            } else {
                list2.add(nums[i])
            }
        }
        var i = 0
        for (num in list1) {
            nums[i] = num
            i++
        }
        for (num in list2) {
            nums[i] = num
            i++
        }
        return nums
    }
}
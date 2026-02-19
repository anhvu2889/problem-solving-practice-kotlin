package topic.twopointer

/**
 * 27. Remove Element
 * Time: O(n)
 * Space: O(1)
 */
class RemoveElement {
    fun removeElement(nums: IntArray, value: Int): Int {
        var i = 0
        for (num in nums){
            if (num != value) {
                nums[i] = num
                i++
            }
        }
        return i
    }
}
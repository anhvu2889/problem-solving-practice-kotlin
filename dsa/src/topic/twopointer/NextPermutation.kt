package topic.twopointer

/**
 * 31. Next Permutation
 * Time: O(n)
 * Space: O(1)
 */
class NextPermutation {
    fun nextPermutation(nums: IntArray) {
        var i = nums.size - 2
        while( i >= 0 && nums[i] >= nums[i + 1]) {
            i--
        }
        if (i >= 0) {
            var r = nums.size - 1
            while (nums[r] <= nums[i]) {
                r--
            }
            swap(nums, i, r)
        }
        reverse(nums, i + 1, nums.size - 1)
    }

    fun swap(nums: IntArray, a: Int, b: Int) {
        val temp = nums[a]
        nums[a] = nums[b]
        nums[b] = temp
    }

    fun reverse(nums: IntArray, l: Int, r: Int) {
        var i = l
        var j = r
        while (i < j) {
            swap(nums, i, j)
            i++
            j--
        }
    }
}
package topic.twopointer

/**
 * 31. Next Permutation
 * Time: O(n)
 * Space: O(1)
 */
class NextPermutation {
    fun nextPermutation(nums: IntArray) {
        var l = nums.size - 2
        while (l >= 0 && nums[l] >= nums[l + 1]) {
            l--
        }
        if (l >= 0) {
            var j = nums.size - 1
            while (nums[j] <= nums[l]) j--
            swap(nums, l, j)
        }

        reverse(nums, l + 1, nums.size - 1)
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
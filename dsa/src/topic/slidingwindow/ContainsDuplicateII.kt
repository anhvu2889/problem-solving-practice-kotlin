package topic.slidingwindow

/**
 * 219. Contains Duplicate II
 * Time: O(n)
 * Space:O(k)
 */
class ContainsDuplicateII {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        if (nums.isEmpty() || k == 0) return false

        val set = mutableSetOf<Int>()
        for (i in nums.indices) {
            if (set.contains(nums[i])) {
                return true
            }
            set.add(nums[i])
            if (set.size > k) {
                set.remove(nums[i - k])
            }
        }
        return false
    }
}
package top150.hashmap

/**
 * 219. Contains Duplicate II
 * Time: O(n)
 * Space: O(min(n, k))
 */
class ContainsDuplicateII {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val window = HashSet<Int>()
        for (i in nums.indices) {
            val num = nums[i]
            if (num in window)
                return true
            window.add(num)
            if (window.size > k)
                window.remove(nums[i - k])
        }
        return false
    }
}
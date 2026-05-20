package top150.mergeinterval

/**
 * 228. Summary Ranges
 * Time: O(n)
 * Space: O(1)
 */
class SummaryRanges {
    fun summaryRanges(nums: IntArray): List<String> {
        val ans = mutableListOf<String>()
        val n = nums.size
        if (n == 0)
            return ans
        var start = nums[0]
        for (i in 1 until n) {
            if (nums[i] != nums[i - 1] + 1) {
                val end = nums[i - 1]
                if (start != end) {
                    ans.add("$start->$end")
                } else {
                    ans.add(start.toString())
                }
                start = nums[i]
            }
        }

        val end = nums[n - 1]
        if (start != end) {
            ans.add("$start->$end")
        } else {
            ans.add(start.toString())
        }
        return ans
    }
}
package topic.binarysearch

/**
 * 1064. Fixed Point
 * Time: O(n)
 * Space: O(1)
 */
class FixedPoint {
    fun fixedPoint(arr: IntArray): Int {
        var l = 0
        var r = arr.size
        while (l < r) {
            val mid = l + (r - l) / 2
            if (arr[mid] >= mid) {
                r = mid
            } else {
                l = mid + 1
            }
        }
        return if (l < arr.size && arr[l] == l) l else -1
    }
}
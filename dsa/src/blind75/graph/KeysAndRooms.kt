package blind75.graph

/**
 * 841. Keys and Rooms
 * Time: O(V + E)
 * Space: O(V)
 */
class KeysAndRooms {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val visited = BooleanArray(rooms.size)
        val stack = ArrayDeque<Int>()
        stack.addLast(0)
        visited[0] = true
        while (stack.isNotEmpty()) {
            val current = stack.removeLast()
            for (next in rooms[current]) {
                if (!visited[next]) {
                    visited[next] = true
                    stack.addLast(next)
                }
            }
        }
        for (visit in visited) {
            if (!visit)
                return false
        }
        return true
    }
}
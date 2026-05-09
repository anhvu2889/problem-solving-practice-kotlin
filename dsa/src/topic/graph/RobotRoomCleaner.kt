package topic.graph

/**
 * 489. Robot Room Cleaner
 * Time: O(m * n)
 * Space: O(m * n)
 */
class RobotRoomCleaner {
    interface Robot {
        // Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current cell.
        fun move(): Boolean {
            return true
        }

        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        fun turnLeft() {}
        fun turnRight() {}

        // Clean the current cell.
        fun clean() {}
    }

    private val dirs = intArrayOf(-1, 0, 1, 0, -1)
    private val visited = mutableSetOf<Cell>()

    fun cleanRoom(robot: Robot) {
        dfs(robot, Cell(0, 0), 0)
    }

    fun dfs(robot: Robot, cell: Cell, direction: Int) {
        visited.add(cell)
        robot.clean()
        for (i in 0 until 4) {
            val nextDirection = (direction + i) % 4
            val nextCell = Cell(cell.row + dirs[nextDirection], cell.col + dirs[nextDirection + 1])
            if (!visited.contains(nextCell) && robot.move()) {
                dfs(robot, nextCell, nextDirection)
                backToLastState(robot)
            }
            robot.turnRight()
        }
    }

    fun backToLastState(robot: Robot) {
        robot.turnRight()
        robot.turnRight()
        robot.move()
        robot.turnRight()
        robot.turnRight()
    }

    data class Cell(val row: Int, val col: Int)
}
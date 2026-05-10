package contest.biweekly182

class ScoreValidator {
    fun scoreValidator(events: Array<String>): IntArray {
        var counter = 0
        var score = 0
        for (event in events) {
            if (event == "WD" || event == "NB") {
                score++
            } else if (event == "W") {
                counter++
            } else {
                score += event.toInt()
            }
            if (counter == 10) {
                break
            }
        }
        return intArrayOf(score, counter)
    }
}
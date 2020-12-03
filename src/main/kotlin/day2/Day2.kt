package day2

class Day2 {

    fun solveFirstStar(input: List<String>): Int {
        var validPasswords = 0
        for (passwordString in input) {
            val (minValue, maxValue, letter, password) = parseString(passwordString)
            val count = password.count { it == letter }

            if (count in minValue..maxValue) {
                validPasswords++
            }
        }
        return validPasswords
    }

    private fun parseString(passwordString: String): Password {
        val values = passwordString.split("-", " ", ":")
        return Password(
            minValue = values[0].toInt(),
            maxValue = values[1].toInt(),
            letter = values[2][0],
            password = values[4]
        )
    }
}
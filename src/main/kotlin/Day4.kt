import java.util.stream.Collectors

class Day4 {

    fun solveFirstStar(input: List<Map<String, String>>): Long {
        return input.stream()
            .filter(this::passportValid)
            .collect(Collectors.toList()).size.toLong()
    }

    private fun passportValid(input: Map<String, String>): Boolean {
        for (passport in input) {
            val result = when (passport.key) {
                "byr" -> checkBirthYear(passport.value)
                "iyr" -> checkIssueYear(passport.value)
                "eyr" -> checkExpirationYear(passport.value)
                "hgt" -> checkHeight(passport.value)
                "hcl" -> checkHairColor(passport.value)
                "ecl" -> checkEyeColor(passport.value)
                "pid" -> checkPassportId(passport.value)
                "cid" -> true
                else -> false
            }
            if (!result) {
                return false
            }
        }

        if ((input.size == 8) or ((input.size == 7) and (input["cid"] == null))) {
            return true
        }
        return false
    }

    /*byr (Birth Year) - four digits; at least 1920 and at most 2002.
    iyr (Issue Year) - four digits; at least 2010 and at most 2020.
    eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
    hgt (Height) - a number followed by either cm or in:
    If cm, the number must be at least 150 and at most 193.
    If in, the number must be at least 59 and at most 76.
    hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
    ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
    pid (Passport ID) - a nine-digit number, including leading zeroes.
    cid (Country ID) - ignored, missing or not.
*/
    private fun checkBirthYear(birthYear: String): Boolean {
        val birtYearAsInt = birthYear.toInt()
        return (birtYearAsInt >= 1920) and (birtYearAsInt <= 2002)
    }

    private fun checkIssueYear(issueYear: String): Boolean {
        val issueYearAsInt = issueYear.toInt()
        return (issueYearAsInt >= 2010) and (issueYearAsInt <= 2020)
    }

    private fun checkExpirationYear(expirationYear: String): Boolean {
        val expirationYearAsInt = expirationYear.toInt()
        return (expirationYearAsInt >= 2020) and (expirationYearAsInt <= 2030)
    }

    private fun checkHeight(height: String): Boolean {
        /* hgt (Height) - a number followed by either cm or in:
        If cm, the number must be at least 150 and at most 193.
        If in, the number must be at least 59 and at most 76.
         */
        val cmRegex = Regex("([\\d]{3}cm)")
        val inRegex = Regex("([\\d]{2}in)")
        return when (height.length) {
            4 -> inRegex.containsMatchIn(height)
            5 -> cmRegex.containsMatchIn(height)
            else -> false
        }
    }

    private fun checkHairColor(hairColor: String): Boolean {
        //hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
        val regex = Regex("(#[a-f,\\d]{6})")
        return regex.containsMatchIn(hairColor)
    }

    private fun checkEyeColor(eyeColor: String): Boolean {
        // ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
        val listOfEyeColors = listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
        return listOfEyeColors.contains(eyeColor)
    }

    private fun checkPassportId(passportId: String): Boolean {
        //pid (Passport ID) - a nine-digit number, including leading zeroes.
        return (passportId.length == 9) and (passportId.toCharArray().all { it.isDigit() })
    }


}
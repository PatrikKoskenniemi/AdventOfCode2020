import org.junit.Assert
import org.junit.Test

class Day4Test {

    private val day4Solver = Day4()
    private val inputReader = InputReader()

    @Test
    fun exampleTestStar1() {
        val input = """
            ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
            byr:1937 iyr:2017 cid:147 hgt:183cm
            
            iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884
            hcl:#cfa07d byr:1929
            
            hcl:#ae17e1 iyr:2013
            eyr:2024
            ecl:brn pid:760753108 byr:1931
            hgt:179cm
            
            hcl:#cfa07d eyr:2025 pid:166559648
            iyr:2011 ecl:brn hgt:59in""".trimIndent()
            .split("\n\n")
        val passports = ArrayList<Map<String, String>>()
        for (passport in input) {
            val passportMap = HashMap<String, String>()
            val pairs = passport.split(" ", "\n")
            for (pair in pairs) {
                val split = pair.split(":")
                passportMap[split[0]] = split[1]
            }
            passports.add(passportMap)
        }
        val solution = day4Solver.solveFirstStar(passports)
        Assert.assertEquals(2, solution)
    }

    @Test
    fun realTestStar1() {
        val passports = inputReader.readDayFourAsListOfMap("input_day4.txt")
        val solution = day4Solver.solveFirstStar(passports)
        println("Solution:$solution")
    }
}
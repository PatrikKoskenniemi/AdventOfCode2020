import org.junit.Assert
import org.junit.Test

class Day5Test {

    private val day5Solver = Day5()
    private val inputReader = InputReader()

    @Test
    fun exampleTestStar1() {
        val input = """
            BFFFBBFRRR
            FFFBBBFRRR
            BBFFBBFRLL
            """.trimIndent()
            .split("\n")

        val solution = day5Solver.solveFirstStar(input)
        Assert.assertEquals(820, solution)
    }

    @Test
    fun realTestStar1() {
        val input = inputReader.readDayFiveAsString("input_day5.txt")
        val solution = day5Solver.solveFirstStar(input)
        println("Solution:$solution")
    }
}
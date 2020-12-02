import org.junit.Assert
import org.junit.Test

class Day1Test {

    private val day1Solver = Day1()
    private val inputReader = InputReader()

    @Test
    fun exampleTestStar1() {
        val numbers = listOf(1721, 979, 366, 299, 675, 1456)
        val solution = day1Solver.solveFirstStar(numbers)
        Assert.assertEquals(1721 * 299, solution)
    }

    @Test
    fun realTestStar1() {
        val inputDayOne = inputReader.readDayOneAsInt("input_day1.txt")
        val solution = day1Solver.solveFirstStar(inputDayOne)
        println("Solution:$solution")
    }
}
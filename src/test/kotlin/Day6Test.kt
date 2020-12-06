import org.junit.Assert
import org.junit.Test

class Day6Test {

    private val day6Solver = Day6()
    private val inputReader = InputReader()

    @Test
    fun exampleTestStar1() {
        val input = """
            abc
            
            a
            b
            c
            
            ab
            ac
            
            a
            a
            a
            a
            
            b
            """.trimIndent()
            .split("\n\n")

        val solution = day6Solver.solveFirstStar(input)
        Assert.assertEquals(11, solution)
    }

    @Test
    fun realTestStar1() {
        val input = inputReader.readDaySixAsListOfMap("input_day6.txt")
        val solution = day6Solver.solveFirstStar(input)
        println("Solution:$solution")
    }
}
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
        val input = inputReader.readDaySixAsListOfString("input_day6.txt")
        val solution = day6Solver.solveFirstStar(input)
        println("Solution:$solution")
    }

    @Test
    fun exampleTestStar2() {
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
            
            j
            j
            j
            jc
            j
            """.trimIndent()
            .split("\n\n")

        val solution = day6Solver.solveSecondStar(input)
        Assert.assertEquals(7, solution)
    }

    @Test
    fun realTestStar2() {
        val input = inputReader.readDaySixAsListOfString("input_day6.txt")
        val solution = day6Solver.solveSecondStar(input)
        println("Solution:$solution")
    }
}
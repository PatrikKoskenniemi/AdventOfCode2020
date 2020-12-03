package day2

import InputReader
import org.junit.Assert
import org.junit.Test

class Day2Test {

    private val day2Solver = Day2()
    private val inputReader = InputReader()

    @Test
    fun exampleTestStar1() {
        var input = listOf("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc")
        val solution = day2Solver.solveFirstStar(input)
        Assert.assertEquals(2, solution)
    }

    @Test
    fun realTestStar1() {
        var input = inputReader.readDayTwoAsString("input_day2.txt")
        val solution = day2Solver.solveFirstStar(input)
        println("Solution:$solution")
    }
}
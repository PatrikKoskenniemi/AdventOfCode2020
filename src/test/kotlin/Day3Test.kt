import org.junit.Assert
import org.junit.Test

class Day3Test {

    private val day3Solver = Day3()
    private val inputReader = InputReader()

    @Test
    fun exampleTestStar1() {
        val input = """
            ..##.......
            #...#...#..
            .#....#..#.
            ..#.#...#.#
            .#...##..#.
            ..#.##.....
            .#.#.#....#
            .#........#
            #.##...#...
            #...##....#
            .#..#...#.#""".trimIndent()
            .split("\n")

        val width = 11
        val solution = day3Solver.solveFirstStar(input)
        Assert.assertEquals(7, solution)
    }

    @Test
    fun realTestStar1() {
        val input = inputReader.readDayThreeAsList("input_day3.txt")
        val solution = day3Solver.solveFirstStar(input)
        println("Solution:$solution")
    }
}
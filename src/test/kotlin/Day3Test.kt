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

        val solution = day3Solver.solveFirstStar(input, Pair(3, 1))
        Assert.assertEquals(7, solution)
    }

    @Test
    fun realTestStar1() {
        val input = inputReader.readDayThreeAsList("input_day3.txt")
        val solution = day3Solver.solveFirstStar(input, Pair(3, 1))
        println("Solution:$solution")
    }

    @Test
    fun exampleTestStar2Individual() {
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


        val pairs = listOf(Pair(1, 1), Pair(3, 1), Pair(5, 1), Pair(7, 1), Pair(1, 2))

        Assert.assertEquals(2, day3Solver.solveFirstStar(input, pairs[0]))
        Assert.assertEquals(7, day3Solver.solveFirstStar(input, pairs[1]))
        Assert.assertEquals(3, day3Solver.solveFirstStar(input, pairs[2]))
        Assert.assertEquals(4, day3Solver.solveFirstStar(input, pairs[3]))
        Assert.assertEquals(2, day3Solver.solveFirstStar(input, pairs[4]))
    }

    @Test
    fun exampleTestStar2() {
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

        val pairs = listOf(Pair(1, 1), Pair(3, 1), Pair(5, 1), Pair(7, 1), Pair(1, 2))

        val solution = day3Solver.solveSecondStar(input, pairs)
        Assert.assertEquals(336, solution)
    }

    @Test
    fun realTestStar2Individual() {
        val input = inputReader.readDayThreeAsList("input_day3.txt")

        val pairs = listOf(Pair(1, 1), Pair(3, 1), Pair(5, 1), Pair(7, 1), Pair(1, 2))

        println(day3Solver.solveFirstStar(input, pairs[0]))
        println(day3Solver.solveFirstStar(input, pairs[1]))
        println(day3Solver.solveFirstStar(input, pairs[2]))
        println(day3Solver.solveFirstStar(input, pairs[3]))
        println(day3Solver.solveFirstStar(input, pairs[4]))
    }

    @Test
    fun realTestStar2() {
        val input = inputReader.readDayThreeAsList("input_day3.txt")

        val pairs = listOf(Pair(1, 1), Pair(3, 1), Pair(5, 1), Pair(7, 1), Pair(1, 2))
        val solution = day3Solver.solveSecondStar(input, pairs)
        println("Solution:$solution")
    }
}
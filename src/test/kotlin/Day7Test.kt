import org.junit.Assert
import org.junit.Test

class Day7Test {

    private val day7Solver = Day7()
    private val inputReader = InputReader()

    @Test
    fun exampleTestStar1() {
        val input = """
            light red bags contain 1 bright white bag, 2 muted yellow bags.
            dark orange bags contain 3 bright white bags, 4 muted yellow bags.
            bright white bags contain 1 shiny gold bag.
            muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
            shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
            dark olive bags contain 3 faded blue bags, 4 dotted black bags.
            vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
            faded blue bags contain no other bags.
            dotted black bags contain no other bags.
            """.trimIndent()
            .split("\n").toMutableList()

        val solution = day7Solver.solveFirstStar(input)
        Assert.assertEquals(4, solution)
    }

    @Test
    fun realTestStar1() {
        val input = inputReader.readDaySevenAsListOfString("input_day7.txt").toMutableList()
        val solution = day7Solver.solveFirstStar(input)
        println("Solution:$solution")
    }
}
class Day3 {

    fun solveFirstStar(input: List<String>, instruction: Pair<Int, Int>): Long {
        val stepsRight = instruction.first
        val stepsDown = instruction.second
        val width = input[0].length
        var nrOfTrees: Long = 0
        for (index in input.indices) {
            if (index * stepsDown > input.size - 1) {
                return nrOfTrees
            }
            val row = index * stepsDown
            val column = (stepsRight * index).rem(width)
            if (input[row][column] == '#') {
                nrOfTrees += 1
            }
        }
        return nrOfTrees
    }

    fun solveSecondStar(input: List<String>, instructions: List<Pair<Int, Int>>): Long {
        return instructions.stream()
            .map { solveFirstStar(input, it) }
            .reduce(1) { a, b -> a * b }
    }
}
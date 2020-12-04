class Day3 {

    fun solveFirstStar(input: List<String>): Int {
        val width = input[0].length
        var nrOfTrees = 0
        for (index in input.indices) {
            if (index == input.lastIndex) {
                return nrOfTrees
            }
            val nextRow = index + 1
            val position = (nextRow.times(3)).rem(width)
            if (input[nextRow][position] == '#') {
                nrOfTrees += 1
            }
        }
        return nrOfTrees
    }

}
class Day6 {

    fun solveFirstStar(input: List<String>): Long {
        var sum = 0L
        for (group in input) {
            sum = sum.plus(group.toCharArray().distinct().filter { it != '\n' }.count())
        }
        return sum
    }
}
class Day6 {

    fun solveFirstStar(input: List<String>): Long {
        var sum = 0L
        for (group in input) {
            sum = sum.plus(group.toCharArray().distinct().filter { it != '\n' }.count())
        }
        return sum
    }

    fun solveSecondStar(input: List<String>): Long {
        var sum = 0L
        for (group in input) {
            val personsInGroup = group.split("\n")
            var matches: Set<Char> = personsInGroup[0].toSet()
            for (person in personsInGroup.drop(1)) {
                matches = person.toCharArray().intersect(matches)
            }
            sum = sum.plus(matches.size)
        }
        return sum
    }
}
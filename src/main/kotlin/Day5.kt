import java.util.stream.Collectors

class Day5 {

    fun solveFirstStar(input: List<String>): Long {
        return input.stream()
            .map(this::findSeatId)
            .max(Long::compareTo).get()
    }

    fun solveSecondStar(input: List<String>): Long {
        val listOfSeatIds = input.stream()
            .map(this::findSeatId)
            .sorted()
            .collect(Collectors.toList())

        for ((index, seatId) in listOfSeatIds.withIndex()) {
            if ((listOfSeatIds[index + 1] != seatId + 1)) {
                return listOfSeatIds[index + 1] - 1
            }
        }
        return 0
    }

    private fun findSeatId(code: String): Long {
        val row = code.substring(0, 7).replace('F', '0').replace('B', '1')
        val column = code.substring(7).replace('L', '0').replace('R', '1')

        val seatId: Long = Integer.parseInt(row, 2).times(8L).plus(Integer.parseInt(column, 2))

        return seatId
    }
}
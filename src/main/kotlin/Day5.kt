class Day5 {

    fun solveFirstStar(input: List<String>): Long {
        return input.stream()
            .map(this::findSeatId)
            .max(Long::compareTo).get()
    }

    private fun findSeatId(code: String): Long {
        val row = code.substring(0, 7).replace('F', '0').replace('B', '1')
        val column = code.substring(7).replace('L', '0').replace('R', '1')

        val seatId: Long = Integer.parseInt(row, 2).times(8L).plus(Integer.parseInt(column, 2))

        return seatId
    }
}
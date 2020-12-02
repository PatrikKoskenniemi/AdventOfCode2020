private const val MAGIC_NUMBER: Int = 2020

class Day1 {

    fun solveFirstStar(numbers: List<Int>): Int {
        var store = arrayOfNulls<Int?>(MAGIC_NUMBER)

        for (number in numbers) {
            if (store[number] != null) {
                return number.times(store[number]!!)
            }
            store[MAGIC_NUMBER - number] = number
        }
        return 0
    }
}
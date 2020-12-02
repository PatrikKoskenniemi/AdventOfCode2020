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

    fun solveSecondStar(numbers: List<Int>): Int {
        var store = arrayOfNulls<Int?>(MAGIC_NUMBER)
        for (number1 in numbers) {
            for (number2 in numbers) {
                for (number3 in numbers) {
                    if (number1 + number2 + number3 == MAGIC_NUMBER) {
                        return number1.times(number2).times(number3)
                    }
                }
            }
        }
        return 0
    }
}
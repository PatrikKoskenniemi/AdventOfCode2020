import java.util.stream.Collectors

class Day4 {

    fun solveFirstStar(input: List<Map<String, String>>): Long {
        return input.stream()
            .filter(this::passportValid)
            .collect(Collectors.toList()).size.toLong()
    }

    private fun passportValid(input: Map<String, String>): Boolean {
        if ((input.size == 8) or ((input.size == 7) and (input["cid"] == null))) {
            return true
        }
        return false
    }
}
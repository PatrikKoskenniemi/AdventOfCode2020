class Day7() {

    private var bags = mutableMapOf<String, Boolean>()
    private val EMPTY_BAG = "no other bags"
    private val SHINY_BAG = "shiny gold bag"
    private val SHINY_BAGS = "shiny gold bags"

    fun solveFirstStar(input: MutableList<String>): Int {
        bags = input.associateBy({ it }, { false }).toMutableMap()

        val foundRows = ArrayList<String>()
        for ((row, processed) in bags) {
            if (row.startsWith(SHINY_BAGS)) {
                bags[row] = true
            } else if (!processed and row.contains(SHINY_BAG).or(row.contains(SHINY_BAGS))) {
                foundRows.add(row)
                bags[row] = true
                foundRows.addAll(recursiveLookup(row.split("contain")[0], foundRows))
            }
        }
        return foundRows.distinct().size
    }

    private fun recursiveLookup(bagKey: String, foundRows: ArrayList<String>): List<String> {
        var foundMatch = false
        for ((row, processed) in bags) {
            if (!processed and row.contains(bagKey.trim().replace("bags", "bag"))) {
                foundMatch = true
                foundRows.add(row)
                bags[row] = true
                recursiveLookup(row.split("contain")[0], foundRows)
            }
        }
        return if (!foundMatch) {
            foundRows
        } else {
            emptyList()
        }

    }
}
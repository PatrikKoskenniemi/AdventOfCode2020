import java.util.stream.Collectors

class Day7 {

    private val EMPTY_BAG = "no other bag"
    private val SHINY_BAG = "shiny gold bag"
    private val SHINY_BAGS = "shiny gold bags"

    fun solveFirstStar(input: MutableList<String>): Int {
        val bags = input.associateBy({ it }, { false }).toMutableMap()

        val foundRows = ArrayList<String>()
        for ((row, processed) in bags) {
            if (row.startsWith(SHINY_BAGS)) {
                bags[row] = true
            } else if (!processed and row.contains(SHINY_BAG).or(row.contains(SHINY_BAGS))) {
                foundRows.add(row)
                bags[row] = true
                foundRows.addAll(recursiveLookupStar1(bags, row.split("contain")[0], foundRows))
            }
        }
        return foundRows.distinct().size
    }

    private fun recursiveLookupStar1(
        bags: MutableMap<String, Boolean>,
        bagKey: String,
        foundRows: ArrayList<String>
    ): List<String> {
        var foundMatch = false
        for ((row, processed) in bags) {
            if (!processed and row.contains(bagKey.trim().replace("bags", "bag"))) {
                foundMatch = true
                foundRows.add(row)
                bags[row] = true
                recursiveLookupStar1(bags, row.split("contain")[0], foundRows)
            }
        }
        return if (!foundMatch) {
            foundRows
        } else {
            emptyList()
        }
    }

    fun solveSecondStar(input: MutableList<String>): Int {
        val bags = HashMap<String, List<String>>()
        for (bagRow in input) {
            val bagRule = bagRow.split("contain", ",").stream()
                .map { it.removeSuffix(".") }
                .map { it.replace("bags", "bag") }
                .map { it.trim() }
                .collect(Collectors.toList())

            val bagRuleDescription = bagRule.subList(1, bagRule.size)
            bags[bagRule[0]] = bagRuleDescription

            val startKeys = ArrayList<String>()
            startKeys.addAll(
                bagRuleDescription.stream()
                    .filter { it.contains(SHINY_BAG) }
                    .collect(Collectors.toList()))
        }
        val recursiveLookup2 = recursiveLookupStar2(bags, "shiny gold bag", 1, 0)
        return recursiveLookup2.minus(1)
    }

    private fun recursiveLookupStar2(
        bags: HashMap<String, List<String>>,
        bagKey: String,
        multiplier: Int,
        sum: Int
    ): Int {
        var localSum = 0
        val bagRuleDescriptions = bags[bagKey]
        if (bagRuleDescriptions != null) {
            for (bagRuleDescription in bagRuleDescriptions) {
                if (bagRuleDescription == EMPTY_BAG) {
                    return multiplier
                }
                val multiplierAndBagKey = bagRuleDescription.split(" ", limit = 2)
                val newMultiplier = multiplier.times(multiplierAndBagKey[0].toInt())
                localSum = localSum.plus(recursiveLookupStar2(bags, multiplierAndBagKey[1], newMultiplier, sum))
            }
        }
        return sum.plus(localSum).plus(multiplier)
    }
}
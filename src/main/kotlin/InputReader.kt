import java.io.File


class InputReader {

    fun readDayOneAsInt(fileName: String): List<Int> {
        val inputStream = javaClass.classLoader.getResource(fileName)
        val result = ArrayList<Int>()
        File(inputStream.toURI())
            .forEachLine { result.add(it.toInt()) }
        return result
    }

    fun readDayTwoAsString(fileName: String): List<String> {
        val inputStream = javaClass.classLoader.getResource(fileName)
        val result = ArrayList<String>()
        File(inputStream.toURI())
            .forEachLine { result.add(it) }
        return result
    }

    fun readDayThreeAsList(fileName: String): List<String> {
        val inputStream = javaClass.classLoader.getResource(fileName)
        val result = ArrayList<String>()
        File(inputStream.toURI())
            .forEachLine { result.add(it) }
        return result
    }

    fun readDayFourAsListOfMap(fileName: String): List<Map<String, String>> {
        val inputStream = javaClass.classLoader.getResource(fileName)
        val result = File(inputStream.toURI())
            .readText().split("\n\n")

        val passports = ArrayList<Map<String, String>>()
        for (passport in result) {
            val passportMap = HashMap<String, String>()
            val pairs = passport.split(" ", "\n")
            for (pair in pairs) {
                val split = pair.split(":")
                if (split.size == 2) {
                    passportMap[split[0]] = split[1]
                } else {
                    println(pair)
                }
            }
            passports.add(passportMap)
        }
        return passports
    }

    fun readDayFiveAsString(fileName: String): List<String> {
        val inputStream = javaClass.classLoader.getResource(fileName)
        val result = ArrayList<String>()
        File(inputStream.toURI())
            .forEachLine { result.add(it) }
        return result
    }

    fun readDaySixAsListOfMap(fileName: String): List<String> {
        val inputStream = javaClass.classLoader.getResource(fileName)
        val result = File(inputStream.toURI())
            .readText().split("\n\n")

        return result
    }
}

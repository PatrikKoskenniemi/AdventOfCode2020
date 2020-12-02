import java.io.File


class InputReader {

    fun readDayOneAsInt(fileName: String): List<Int> {
        val inputStream = javaClass.classLoader.getResource(fileName)
        val result = ArrayList<Int>()
        File(inputStream.toURI())
            .forEachLine { result.add(it.toInt()) }
        return result
    }

}

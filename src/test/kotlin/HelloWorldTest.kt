import org.junit.Assert
import kotlin.test.Test

class HelloWorldTest {

    private val helloWorld = HelloWorld()

    @Test
    fun testHelloWorld() {
        val helloWorld1 = helloWorld.getHelloWorld()
        Assert.assertEquals("Hello World", helloWorld1)
    }
}
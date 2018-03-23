package jacksonMapper

import junit.framework.Assert.assertEquals
import org.junit.Test
import java.io.File

class JsonParserTest {



    @Test
    fun testJsonParser() {
        val json = File("/home/sander/dev/kotlin/tutorial/kotlin-koans/test/jacksonMapper/TestJson.json").readText()

        val parser = JsonParser()
        val result = parser.parseJson(json)
        val eersteQueue = result.elementAt(0)
        assertEquals("ipde-input-queue", eersteQueue.name)
        assertEquals(listOf(3, 3, 3, 12, 10, 8, 6, 4, 2), eersteQueue.priorities)

        val tweedeQueue = result.elementAt(1)
        assertEquals("batch-input-queue", tweedeQueue.name)
        assertEquals(listOf(453, 34, 63, 127, 106, 58, 63, 42, 12), tweedeQueue.priorities)
    }

}
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
        assertEquals(listOf(2, 4, 6, 8, 10, 12, 3, 3, 3), eersteQueue.priorities)

        val tweedeQueue = result.elementAt(1)
        assertEquals("batch-input-queue", tweedeQueue.name)
        assertEquals(listOf(12, 42, 63, 58, 106, 127, 63, 34, 453), tweedeQueue.priorities)
    }

}
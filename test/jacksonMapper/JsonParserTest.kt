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
        val eersteElement = result.elementAt(0)
        assertEquals("ipde-input-queue", eersteElement.name)
//        assertEquals(19, eersteElement.priorities)
//        assertEquals("genest ei", eersteElement.ei)

        val tweedeElement = result.elementAt(1)
        assertEquals("batch-input-queue", tweedeElement.name)
//        assertEquals(20, tweedeElement.priorities)
//        assertEquals("genest eitje", tweedeElement.ei)
    }

}
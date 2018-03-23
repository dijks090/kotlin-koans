package jacksonMapper

import junit.framework.Assert.assertEquals
import org.junit.Assert
import org.junit.Test
import java.io.File

class JsonParserTest {



    @Test
    fun testJsonParser() {
        val json = File("/home/sander/dev/kotlin/tutorial/kotlin-koans/test/jacksonMapper/TestJson.json").readText()

        val parser = JsonParser()
        val result = parser.parseJson(json)
        val eersteElement = result.elementAt(0)
        assertEquals("Sander", eersteElement.name)
        assertEquals(44, eersteElement.age)
        assertEquals("genest ei", eersteElement.ei)

        val tweedeElement = result.elementAt(1)
        assertEquals("Blanka", tweedeElement.name)
        assertEquals(43, tweedeElement.age)
        assertEquals("genest eitje", tweedeElement.ei)
    }

}
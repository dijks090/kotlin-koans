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
        val ipdeInputQueue = result.find { it.name == "ipde-input-queue" }
        assertEquals("ipde-input-queue", ipdeInputQueue?.name)
        assertEquals(listOf(3, 3, 3, 12, 10, 8, 6, 4, 2), ipdeInputQueue?.priorities)

        val ipdeBatchQueue = result.find { it.name == "batch-input-queue" }
        assertEquals("batch-input-queue", ipdeBatchQueue?.name)
        assertEquals(listOf(453, 34, 63, 127, 106, 58, 63, 42, 12), ipdeBatchQueue?.priorities)
    }

}
package jacksonMapper

import junit.framework.Assert.assertEquals
import klooien.Compressor
import org.junit.Ignore
import org.junit.Test
import java.io.File
import java.io.InputStream

class JsonParserTest {



    @Ignore
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

    @Test
    fun testCompressor(){
        var gzipper = Compressor()

        val file = File("/home/sander/dev/kotlin/tutorial/kotlin-koans/test/jacksonMapper/TestJson.json")
        val inputStream: InputStream = file.inputStream()
        val inputString = inputStream.bufferedReader().use { it.readText() }

        println("size of original: ${inputString.length}")

        val gezipped = gzipper.gzip(inputString)
        println("size zipped: ${gezipped.size}")
        val unzipped = gzipper.ungzip(gezipped)

        assertEquals(inputString, unzipped)

    }

    @Test
    fun testCompressorByteArray(){
        var gzipper = Compressor()

        val file = File("/home/sander/dev/kotlin/tutorial/kotlin-koans/test/jacksonMapper/TestJson.json")
        val inputStream: InputStream = file.inputStream()
        val inputString = inputStream.bufferedReader().use { it.readText() }

        println("size of original: ${inputString.length}")

        val gezipped = gzipper.gzipNieuw(inputString.toByteArray())
        val gezipped2 = gzipper.gzip(inputString)

        println("size zipped: ${gezipped.size}")
        println("size zipped2: ${gezipped2.size}")

        val unzipped = gzipper.ungzip(gezipped)
        assertEquals(unzipped, inputString)
        assertEquals(gezipped.size, gezipped2.size)

        val dezedan = gzipper.ungzipN(gezipped)

        assertEquals(dezedan.toString(), inputString)


//        val unzipped = gzipper.ungzipN(gezipped)
//        print(unzipped)
//        assertEquals(inputString, unzipped)

    }

}
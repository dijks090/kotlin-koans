package klooien

import jacksonMapper.JsonParser
import junit.framework.Assert.assertEquals
import org.junit.Test
import java.io.File
import java.io.InputStream

class CompressorTest {

    @Test
    fun testJsonParser() {

        var gzipper = Compressor()

        //TODO: relative path
        val file = File("/home/sander/dev/kotlin/tutorial/kotlin-koans/test/jacksonMapper/TestJson.json")
//    val file = File("/Users/dijkstra.s/dev/ipde-rekenen/commons/communication/src/test/kotlin/nl/tkp/ipde/communication/rabbitmq/util/content.txt")
        val inputStream: InputStream = file.inputStream()
        val inputString = inputStream.bufferedReader().use { it.readText() }

        println("size of original: ${inputString.length}")

        //                val stringtozip = "testing testing"
        val gezipped = gzipper.gzip(inputString)
        println("size zipped: ${gezipped.size}")
        val unzipped = gzipper.ungzip(gezipped)

        assertEquals(inputString, unzipped)

//    //                val stringtozip = "testing testing"
//    val gezipped = gzipper.gzipNieuw(inputString.toByteArray())
//    println("size zipped: ${gezipped.size}")
//    val unzipped = gzipper.ungzipNieuw(gezipped)
//
//    assertEquals(inputString.toByteArray(), unzipped)

    }
}
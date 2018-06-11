package klooien

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.nio.charset.StandardCharsets.UTF_8
import java.util.zip.GZIPInputStream
import java.util.zip.GZIPOutputStream

class Compressor {


    fun gzip(content: String): ByteArray {
        val bos = ByteArrayOutputStream()
        GZIPOutputStream(bos).bufferedWriter(UTF_8).use { it.write(content) }
        return bos.toByteArray()
    }

    fun ungzip(content: ByteArray): String =
            GZIPInputStream(content.inputStream()).bufferedReader(UTF_8).use { it.readText() }

    fun ungzipN(content: ByteArray): ByteArray {
        return GZIPInputStream(content.inputStream()).readAllBytes() }

    fun gzipNieuw(content: ByteArray): ByteArray {
        val bos = ByteArrayOutputStream()
        val zipOutputStream = GZIPOutputStream(bos)
        zipOutputStream.write(content)
        bos.close()
        zipOutputStream.close()
        return bos.toByteArray()
    }

    fun ungzipNieuw(content: ByteArray): ByteArray {
        val bin = ByteArrayInputStream(content)
        val gzipper = GZIPInputStream(bin)
//       return GZIPInputStream(content.inputStream()).readBytes()
        val buffer = ByteArray(1024)
        val out = ByteArrayOutputStream()

//        gzipper.read
        gzipper.copyTo(out, DEFAULT_BUFFER_SIZE)

        gzipper.close()
        out.close()
        return out.toByteArray()
    }


}



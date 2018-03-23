package jacksonMapper

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.databind.JsonNode


class JsonParser {

    fun parseJson(json: String) : List<Queue> {
        val mapper: ObjectMapper = ObjectMapper().registerModule(KotlinModule())
        val module = SimpleModule()
        module.addDeserializer(Queue::class.java, ItemDeserializer())
        mapper.registerModule(module)
        return mapper.readValue(json)
    }
}

class ItemDeserializer: StdDeserializer<Queue>(Queue::class.java) {
    override fun deserialize(parser: JsonParser, ctxt: DeserializationContext?): Queue {
        while (parser.nextToken() != JsonToken.END_OBJECT) {
            val node: JsonNode = parser.codec.readTree(parser)
            val prios  = mutableListOf<Int>()
            node.get("queue-lengths").get("priorities")?.elements()?.forEach { prios.add( it.asInt()) }
            return Queue(node.get("queue-name").textValue(), prios)
        }
        return Queue()
    }
}

data class Queue(val name: String = "", val priorities: MutableList<Int>? = mutableListOf() )

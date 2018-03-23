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

    fun parseJson(json: String) : List<Item> {
        val mapper: ObjectMapper = ObjectMapper().registerModule(KotlinModule())
        val module = SimpleModule()
        module.addDeserializer(Item::class.java, ItemDeserializer())
        mapper.registerModule(module)
        return mapper.readValue<List<Item>>(json)
    }
}

class ItemDeserializer: StdDeserializer<Item>(Item::class.java) {
    override fun deserialize(parser: JsonParser, ctxt: DeserializationContext?): Item {
        while (parser.nextToken() != JsonToken.END_OBJECT) {
            val node: JsonNode = parser.codec.readTree(parser)
            return Item(node.get("name").textValue(), node.get("age").asInt(), node.get("nest").get("ei").textValue())
            println(node)
        }
        return Item()
    }
}

data class Item(val name: String = "", val age: Int = 0, val ei: String = "")

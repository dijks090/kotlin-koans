package jacksonMapper

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue


class JsonParser {

    fun parseJson(json: String) : List<Item> {
        val mapper: ObjectMapper = ObjectMapper().registerModule(KotlinModule())
        val module = SimpleModule()
        module.addDeserializer(Item::class.java, ItemDeserializer())
        mapper.registerModule(module)
        return mapper.readValue<List<Item>>(json)
    }
}

//https://www.programcreek.com/java-api-examples/?class=com.fasterxml.jackson.core.JsonParser&method=readValueAs
class ItemDeserializer: StdDeserializer<Item>(Item::class.java) {
    override fun deserialize(parser: JsonParser, ctxt: DeserializationContext?): Item {
        while (parser.nextToken() != JsonToken.END_OBJECT) {
//            println(parser.getCurrentName())
            println(parser.valueAsString)
//            println(parser.currentToken)
        }

//        return parser.readValueAs(Item::class.java)
        return Item("name")
    }
}

data class Item(val name: String, val age: Int = 0)

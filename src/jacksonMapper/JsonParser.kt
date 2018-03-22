package jacksonMapper

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.databind.JsonNode





class JsonParser {

    fun parseJson(json: String) : Item {
        val mapper: ObjectMapper = ObjectMapper().registerModule(KotlinModule())
        val module = SimpleModule()
        module.addDeserializer(Item::class.java, ItemDeserializer())
        mapper.registerModule(module)
        return mapper.readValue(json)
    }
}

class ItemDeserializer: StdDeserializer<Item>(Item::class.java) {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): Item {
        val node = p?.nextFieldName()
        return Item(name = node!!)
    }
}

data class Item(val name: String)

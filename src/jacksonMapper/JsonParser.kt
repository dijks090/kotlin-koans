package jacksonMapper

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue



class JsonParser {


//    ObjectMapper mapper = new ObjectMapper();
//    SimpleModule module = new SimpleModule();
//    module.addDeserializer(Item.class, new ItemDeserializer());
//    mapper.registerModule(module);
//
//    Item readValue = mapper.readValue(json, Item.class);



    fun parseJson(json: String) : MyStateObject {
        val mapper: ObjectMapper = ObjectMapper().registerModule(KotlinModule())
//        val module: SimpleModule = SimpleModule()
//        module.addDeserializer()
        return mapper.readValue<MyStateObject>(json)
    }
}
data class MyStateObject(val name: String, val age: Int)
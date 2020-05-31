package fr.cleymax.trelloapi.utils

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class MutableMapAdapter : JsonDeserializer<Map<String, String>> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Map<String, String> {
        if (json == null || !json.isJsonObject) return mapOf()
        val map = mutableMapOf<String, String>()
        json.asJsonObject.entrySet().forEach { map[it.key] = it.value.asString }
        return map
    }
}

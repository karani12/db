package core

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

//import org.json.JSONObject
data class Column(val name: String, val dataType: String)
data class Table(val name: String, val columns: List<Column>)

fun loadSchema(schemaString: String): List<Table> {
    val gson = Gson()
    val listType: Type = object : TypeToken<List<Table>>() {}.type
    return gson.fromJson(schemaString, listType)
}



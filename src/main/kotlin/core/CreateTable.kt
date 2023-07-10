package core

import com.google.gson.Gson
import java.io.File





fun createTable(databaseFilePath: String, schema: List<Table>, tableName: String) {
    val file = File(databaseFilePath)

    if (!file.exists()) {
        throw IllegalArgumentException("Database file $databaseFilePath does not exist.")
    }


    val table = schema.find { it.name == tableName }
        ?: throw IllegalArgumentException("Table $tableName does not exist in the schema.")

    val tableColumns = table.columns.joinToString(", ") { "${it.name} ${it.dataType}" }

    // Create a new table object and add it to the schema
    val newTable = Table(tableName, table.columns)
    val updatedSchema = schema.toMutableList()
    updatedSchema.add(newTable)

    // Update the .reflct file with the modified schema
    val gson = Gson()
    val schemaJson = gson.toJson(updatedSchema)

    file.writeText(schemaJson)

    println("Table $tableName has been created.")
}


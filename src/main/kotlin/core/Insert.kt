package core

import java.io.File

fun processInsertQuery(databaseFilePath: String, schema: List<Table>, tableName: String, values: List<String>) {
    val file = File(databaseFilePath)

    if (!file.exists()) {
        throw IllegalArgumentException("Database file $databaseFilePath does not exist.")
    }

    val table = schema.find { it.name == tableName }
        ?: throw IllegalArgumentException("Table $tableName does not exist.")

    if (values.size != table.columns.size) {
        throw IllegalArgumentException("Invalid number of values for table $tableName.")
    }

    val rowValues = values.joinToString(",")

    // Append the row values to the table section of the .reflct file
    file.appendText("$rowValues\n")

    println("Inserted values into table $tableName.")
}
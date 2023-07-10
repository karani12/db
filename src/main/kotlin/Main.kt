import core.createDatabaseCommand
import core.createTable
import core.loadSchema

fun main(args: Array<String>) {
//    if (args.size != 1) {
//        println("Usage: kotlin DatabaseCommand <databaseFilePath>")
//        return
//    }


    createDatabaseCommand(args)
    val schemaString = """
    [
        {
            "name": "employees",
            "columns": [
            { "name": "id", "type": "INT" },
            { "name": "name", "type": "VARCHAR" },
            { "name": "age", "type": "INT" }
            ]
        },
        {
            "name": "customers",
            "columns": [
            { "name": "id", "type": "INT" },
            { "name": "name", "type": "VARCHAR" },
            { "name": "email", "type": "VARCHAR" }
            ]
        }
    ]
    """
    val databaseFilePath = "./database.reflct" // Specify the path to your custom .reflct database file
    val tableName = "customers" // Specify the name of the table to be inserted

    val schema = loadSchema(schemaString)

    createTable(databaseFilePath, schema, tableName)
//   val tables = loadSchema(schemaString)
//    tables.forEach { table ->
//        println("Table: ${table.name}")
//        table.columns.forEach { column ->
//            println("Column: ${column.name} (${column.dataType})")
//        }
//        println()
//    }

}
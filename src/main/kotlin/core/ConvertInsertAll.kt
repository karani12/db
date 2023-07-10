fun convertSqlToList(sqlStatement: String): List<String> {
    // Remove the "INSERT INTO table_name VALUES (" prefix
    val valuesString = sqlStatement.substringAfter("VALUES (").dropLast(1)

    // Split the values string by commas and trim each value
    return valuesString.split(",").map { it.trim() }
}
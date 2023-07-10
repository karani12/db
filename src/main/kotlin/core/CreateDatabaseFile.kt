package core

import java.io.File

fun createDatabaseFile(databaseFilePath:String){
    val file = File(databaseFilePath)

    file.parentFile.mkdirs()

    file.createNewFile()

    println("Database created at : $databaseFilePath")
}
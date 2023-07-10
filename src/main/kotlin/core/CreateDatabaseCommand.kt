package core


fun createDatabaseCommand(args: Array<String>) {


    if (args.size != 1) {
        println("Usage: kotlin DatabaseCommand <databaseFilePath>")
        return
    }

    val databaseFilePath = args[0]

    createDatabaseFile(databaseFilePath)
}
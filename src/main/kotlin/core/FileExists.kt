import java.io.File

fun fileExists(filePath: String): Boolean {
    val file = File(filePath)
    return file.exists()
}
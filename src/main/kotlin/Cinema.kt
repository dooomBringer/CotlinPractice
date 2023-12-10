class Cinema (
    val name: String,
    val address: String,
) {
    val halls = mutableListOf<Hall>()

    fun printCinemaData() {
        println("""
            Название: $name
            Адрес: $address
        """.trimIndent())
    }
}
class Cinema (
    val name: String,
    val address: String,
    var hallList: MutableList<Hall> = mutableListOf()

) {

    fun printCinemaData() {
        println("""
            Название: $name
            Адрес: $address
        """.trimIndent())
    }
}
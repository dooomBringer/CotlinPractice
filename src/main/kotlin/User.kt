class User(
    val login: String,
    val password: String,
    val isAdmin: Boolean = false,
    var inSystem: Boolean = false,
    var balance: Float = 0f,
) {


    fun printAllUserData () {
        println("""
            login: $login
            password: $password
            adminRights: $isAdmin
            balance: $balance
        """.trimIndent())
    }


}
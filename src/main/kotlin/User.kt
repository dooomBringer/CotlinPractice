class User (
    val login : String,
    val password : String,
    val isAdmin : Boolean = false,
) {

    init {
        println("Пользователь успешно создан")
    }

    fun printAllUserData () {
        println("""
            login: $login
            password: $password
            adminRights: $isAdmin
        """.trimIndent())
    }
}
class User (
    val login : String,
    val password : String,
    val isAdmin : Boolean = false,
    var inSystem : Boolean = false,
) {



    fun printAllUserData () {
        println("""
            login: $login
            password: $password
            adminRights: $isAdmin
        """.trimIndent())
    }


}
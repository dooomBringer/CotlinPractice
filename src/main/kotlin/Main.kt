fun main(args: Array<String>) {

    val userList = mutableListOf<User>()

    printGreetings()
    val currentUser = registration()
    userList.add(currentUser)
    permanentInterface(currentUser, userList)


}

fun permanentInterface(user : User, userList : List<User>) {
    while (true) {

        println("""
           Пожалуйста, выберите одну из опций:
           1. Посмотреть информацию об аккаунте
           2. Посмотреть обо всех аккаунтах
           3. Выйти из аккаунта
       """.trimIndent())

        val userChoice = readln().toInt()
        userOption(userChoice, user, userList)

    }
}

fun printAllUsers(userList: List<User>) {
    userList.forEach {
        it.printAllUserData()
        println("" +
                "")
    }
}


fun printGreetings () {
    println("""
        Добро пожаловать в интерфейс кинотеатра!
    """.trimIndent())
}

fun registration () : User {
    println("""
        Перед тем, как начать работу - зарегистрируйтесь:
    """.trimIndent())
    val login = readLogin()
    val password = readPassword()
    val user = User (
        login = login,
        password = password,
    )
    return user
}

fun readLogin () : String {
    println("Введите ваш логин:")
    return readln()
}

fun readPassword () : String {
    println("Введите ваш пароль:")
    return readln()
}
fun userOption (choice : Int, user : User, userList: List<User>) {
    if (choice == 1) {
        while (true) {
            user.printAllUserData()
            println("" +
                    "")
            break
        }
    } else if (choice == 2) {
        while (true) {
            printAllUsers(userList)
            println("" +
                    "")
            break
        }
    }
}

fun registrationAuthenticationInterface () {
    while (true) {
        println("""
            Выберите одну из опций:
            1. Зарегистрироваться
            2. Войти в существующий аккаунт
        """.trimIndent())
        val userChoice = readln().toInt()
        if (userChoice == 1) {
            // registration
        } else if (userChoice == 2) {
            // authentication
        }
    }
}


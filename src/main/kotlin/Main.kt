fun main(args: Array<String>) {
    printGreetings()
    val currentUser = registration()
    permanentInterface(currentUser)


}



fun permanentInterface(user : User) {
    while (true) {

        println("""
           Пожалуйста, выберите одну из опций:
           1. Посмотреть информацию об аккаунте
           2. Выйти из аккаунта
       """.trimIndent())


        val userChoice = readln().toInt()
        userOption(userChoice, user)

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

fun userOption (choice : Int, user : User) {
    if (choice == 1) {
        while (true) {

            user.printAllUserData()

            println("Чтобы выйти, введи 1")
            if (readln().toInt() == 1) {
                break
            }
        }
    }
}
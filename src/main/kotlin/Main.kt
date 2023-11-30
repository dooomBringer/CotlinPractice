import kotlin.math.log

fun main(args: Array<String>) {

    val userList = mutableListOf<User>()
    var currentUser : User

    while (true) {
        val userChoice = greetingInterface()
        if (userChoice == 1) {
            val accountIndex = authorization(userList)
            currentUser = findAccountInBaseByIndex(userList, accountIndex)
            permanentInterface(currentUser)

        } else if (userChoice == 2) {
            val currentUser = registration(userList)
            userList.add(currentUser)
            permanentInterface(currentUser)
        }
    }
}

fun greetingInterface() : Int {
    println("""
        Привет! Добро пожаловать в наш кинотеатр.
        Перед тем, как приступить к работе выбери одну из опций:
        1. Авторизоваться
        2. Зарегистрироваться   
    """.trimIndent())

    return readln().toInt()
}

fun registration (userList : List<User>) : User {

    var isRegistered = false

    while (!isRegistered) {
        println("Пожалуйста, введите ваш логин:")
        val loginInput = readln()

        if (checkLoginInBase(userList, loginInput)) {
            println("Такой аккаунт уже существует. Введите другой логин:")
        } else {
            isRegistered = true
            println("Пожалуйста, введите ваш пароль:")
            var passwordInput = readln()

            return User (
                login = loginInput,
                password = passwordInput,
                inSystem = true,
            )
        }
    }
    return User (
        login = "UNKNOWN",
        password = "UNKNOWN",
        inSystem = false
    )
}

fun authorization (userList: List<User>) : Int {

    var isLoggedIn = false
    var result = -1


    while (!isLoggedIn) {
        println("Введите ваш логин:")
        val loginInput = readln()
        println("Введите ваш пароль:")
        val passwordInput = readln()

        result = checkAccountInBase(userList, loginInput, passwordInput)

        if (result != -1) {
            isLoggedIn = true
            println("Вы успешно авторизовались")
        }
        else {
            println("Неверные данные или аккаунт не существует")
        }
    }
    return result
}
fun checkLoginInBase (userList : List<User>, userLogin : String) : Boolean {
    userList.forEach {
        if (it.login == userLogin) {return true}
    }
    return false
}

fun checkAccountInBase (userList: List<User>, userLogin : String, userPassword : String) : Int {
    userList.forEachIndexed { i, user ->
        if (user.login == userLogin && user.password == userPassword) {
            return i
        }
        else {
            return -1
        }
    }
    return -1
}

fun findAccountInBaseByIndex (userList: List<User>, index : Int) : User {
    return userList[index]
}

fun permanentInterface (user: User) {
    while (true) {
        println("""
            Выберите один из доступных вариантов:
            1. Выйти из аккаунта
            2. Посмотреть текущую информацию
        """.trimIndent())

        val userChoice = readln().toInt()

        when (userChoice) {
            1 -> {break}
            2 -> printAccountInformation(user)
            // 3 - >
        }
    }
}

fun printAccountInformation (user : User) {
    user.printAllUserData()
}





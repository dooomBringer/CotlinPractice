fun main(args: Array<String>) {


    val userList = mutableListOf<User>()
    var currentUser : User
    var cinemaList = mutableListOf<Cinema>()


    while (true) {
        val userChoice = greetingInterface()
        if (userChoice == 1) {
            val accountIndex = authorization(userList)
            currentUser = findAccountInBaseByIndex(userList, accountIndex)
            if (checkForAdmin(currentUser)) {
                adminPermanentInterface(currentUser, cinemaList)
            }
            permanentInterface(currentUser)

        } else if (userChoice == 2) {
            val currentUser = registration(userList)
            userList.add(currentUser)
            if (checkForAdmin(currentUser)) {
                adminPermanentInterface(currentUser, cinemaList)
            }
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

    while (true) {
        println("Пожалуйста, введите ваш логин:")
        val loginInput = readln()

        if (checkLoginInBase(userList, loginInput)) {
            println("Такой аккаунт уже существует. Введите другой логин:")
        } else {
            println("Пожалуйста, введите ваш пароль:")
            val passwordInput = readln()

            if (askAdminRoots()) {
                return User (
                    login = loginInput,
                    password = passwordInput,
                    inSystem = true,
                    isAdmin = true,
                )
            }

            return User (
                login = loginInput,
                password = passwordInput,
                inSystem = true,
            )
        }
    }
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
    }
    return -1
}

fun findAccountInBaseByIndex (userList: List<User>, index : Int) : User {
    return userList[index]
}



fun adminPermanentInterface (user: User, cinemaList: MutableList<Cinema>) {
    while (true) {
        println("""
            Выберите один из доступных вариантов:
            1. Выйти из аккаунта
            2. Посмотреть текущую информацию
            3. Создать кинотеатр
            4. Посмотреть список существующих кинотеатров
        """.trimIndent())

        val userChoice = readln().toInt()

        when (userChoice) {
            1 -> {break}
            2 -> printAccountInformation(user)
            3 -> cinemaList.add(createCinema())
            4 -> cinemaList.forEach {
                it.printCinemaData()
            }
        }
    }
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

fun askAdminRoots() : Boolean {
    println("""
        Хотите ли вы получить права админа?
        1. Да
        2. Нет
    """.trimIndent())
    val adminInput = readln().toInt()
    if (adminInput == 1) {
        return true
    }
    return false
}

fun checkForAdmin(user : User) : Boolean {
    return user.isAdmin
}

fun createCinema () : Cinema {
    println("Введите название кинотеатра:")
    val cinemaName = readln()
    println("Введите адрес кинотеатра:")
    val cinemaAddress = readln()
    return Cinema(cinemaName, cinemaAddress)
}




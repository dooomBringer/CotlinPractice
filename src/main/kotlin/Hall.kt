abstract class Hall () {
    abstract val name : String
}

class InDoorHall (override val name: String) : Hall() {

}

class OpenAirHall (override val name: String) : Hall() {

}
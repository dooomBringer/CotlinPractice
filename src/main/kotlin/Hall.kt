abstract class Hall () {
    abstract val name : String
    abstract val films : List<Film>

}

class InDoorHall (override val name: String, override val films: List<Film>) : Hall(
) {
}

class OpenAirHall (override val name: String, override val films: List<Film>) : Hall() {
}
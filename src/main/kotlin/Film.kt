class Film (
    val title : String,
    val durability: Int,
    val sessions : List<Session>,
) {
}


// Cinema -> hall -> film -> session -> seats
// user -> tickets
// tickets -> Cinema session && film && hall
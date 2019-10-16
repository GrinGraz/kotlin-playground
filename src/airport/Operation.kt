package airport

internal enum class Operation{
    DisplayAirplanesIds,
    DisplayAirplaneInfoById,
    DisplayAirplaneMaxCapacity,
    DisplayAirplaneCurrentCapacity,
    DisplayAirplaneAvailableSeats,
    DisplayAddPassengers,
    DisplayRemovePassengers,
    BackToMenu,
    Exit
}

internal fun Int?.toOperation() : Operation? {
    return when(this){
        1 -> Operation.DisplayAirplanesIds
        2 -> Operation.DisplayAirplaneInfoById
        3 -> Operation.DisplayAirplaneMaxCapacity
        4 -> Operation.DisplayAirplaneCurrentCapacity
        5 -> Operation.DisplayAirplaneAvailableSeats
        6 -> Operation.DisplayAddPassengers
        7 -> Operation.DisplayRemovePassengers
        8 -> Operation.BackToMenu
        -1 -> Operation.Exit
        else -> Operation.Exit
    }
}
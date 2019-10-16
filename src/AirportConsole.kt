import java.util.*
import kotlin.system.exitProcess

private val airpo = Airpo()

private val menuOptions = listOf(
        "1. display airplanes id",
        "2. display airplane info by id",
        "3. display airplanes max capacity",
        "4. display aiplanes current capacity",
        "5. display airplanes available seats",
        "6. add passenger to airplane by id",
        "7. remove passenger to airplane by id",
        "x. enter any other to exit")

private val reader = Scanner(System.`in`)

fun runAirportConsole() {
    displayAirportMenu()
    displaySelectedOperation(validateOperationSelected(reader.next().toIntOrNull()).toOperation())
    displayBackMenu()
    checkForBackOrExit()
}

private fun displayAirportMenu() {
    "welcome to ${airpo.name}".print()
    "select an operation number".print()
    menuOptions.forEach { it.print() }
    "enter operation number: ".print()
}

private fun displaySelectedOperation(operation: Operation?){
    when(operation){
        Operation.DisplayAirplanesIds -> airpo.displayAirplanesId()
        Operation.DisplayAirplaneInfoByIs -> airpo.displayAirplaneInfoById(getIdInput())
        Operation.DisplayAirplaneMaxCapacity -> airpo.displayAirplanesMaxCapacity()
        Operation.DisplayAirplaneCurrentCapacity -> airpo.displayAirplanesCurrentCapacity()
        Operation.DisplayAirplaneAvailableSeats -> airpo.displayAirplanesAvailableSeats()
        Operation.AddPassengers -> airpo.addPassengers(getIdInput(), getPassengerQuantityInput())
        Operation.RemovePassengers -> airpo.removePassengers(getIdInput(), getPassengerQuantityInput())
        Operation.Back -> runAirportConsole()
        Operation.Exit -> exitProcess(0)
    }
}

private fun getIdInput(): Int {
    displayEnterIdMessage()
    return validateInput(reader.next())
}

private fun getPassengerQuantityInput(): Int {
    displayEnterPassengerCapacityMessage()
    return validateInput(reader.next())
}

private fun validateOperationSelected(operationId: Int?) = if (operationId in 0..8) operationId else null

private fun validateInput(input: String) = input.toIntOrNull() ?: -1

private fun displayEnterIdMessage() = "enter airplane id: ".print()

private fun displayEnterPassengerCapacityMessage() = "enter passengers quantity: ".print()

private fun displayBackMenu() = ("enter 8 to return to menu any other to exit").print()

private fun checkForBackOrExit(){
    val backOrExit = reader.next().toIntOrNull().toOperation()
    if (backOrExit != Operation.Back) exitProcess(0)
    displaySelectedOperation(backOrExit)
}

private enum class Operation{
    DisplayAirplanesIds,
    DisplayAirplaneInfoByIs,
    DisplayAirplaneMaxCapacity,
    DisplayAirplaneCurrentCapacity,
    DisplayAirplaneAvailableSeats,
    AddPassengers,
    RemovePassengers,
    Back,
    Exit
}

private fun Int?.toOperation() : Operation? {
    return when(this){
        1 -> Operation.DisplayAirplanesIds
        2 -> Operation.DisplayAirplaneInfoByIs
        3 -> Operation.DisplayAirplaneMaxCapacity
        4 -> Operation.DisplayAirplaneCurrentCapacity
        5 -> Operation.DisplayAirplaneAvailableSeats
        6 -> Operation.AddPassengers
        7 -> Operation.RemovePassengers
        8 -> Operation.Back
        null -> Operation.Exit
        else -> Operation.Exit
    }
}

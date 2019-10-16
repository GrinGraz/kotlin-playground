package airport

import java.util.*
import kotlin.system.exitProcess

private val airport = Airport()

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
    displaySelectedOperation(reader.next().toValidIntInput().toOperation())
    displayBackMenu()
    checkForBackOrExit()
}

private fun displayAirportMenu() {
    "welcome to ${airport.name}".print()
    "select an operation number".print()
    menuOptions.forEach { it.print() }
    "enter operation number: ".print()
}

private fun displaySelectedOperation(operation: Operation?){
    when(operation){
        Operation.DisplayAirplanesIds -> airport.displayAirplanesId()
        Operation.DisplayAirplaneInfoById -> airport.displayAirplaneInfoById(getIdInput())
        Operation.DisplayAirplaneMaxCapacity -> airport.displayAirplanesMaxCapacity()
        Operation.DisplayAirplaneCurrentCapacity -> airport.displayAirplanesCurrentCapacity()
        Operation.DisplayAirplaneAvailableSeats -> airport.displayAirplanesAvailableSeats()
        Operation.DisplayAddPassengers -> airport.displayAddPassengers(getIdInput(), getPassengerQuantityInput())
        Operation.DisplayRemovePassengers -> airport.displayRemovePassengers(getIdInput(), getPassengerQuantityInput())
        Operation.BackToMenu -> runAirportConsole()
        Operation.Exit -> exitProcess(0)
    }
}

private fun getIdInput(): Int {
    displayEnterIdMessage()
    return reader.next().toValidIntInput()
}

private fun getPassengerQuantityInput(): Int {
    displayEnterPassengerCapacityMessage()
    return reader.next().toValidIntInput()
}

private fun displayEnterIdMessage() = "enter airplane id: ".print()

private fun displayEnterPassengerCapacityMessage() = "enter passengers quantity: ".print()

private fun displayBackMenu() = ("enter 8 to return to menu any other to exit").print()

private fun checkForBackOrExit(){
    val backOrExit = reader.next().toValidIntInput().toOperation()
    if (backOrExit != Operation.BackToMenu) exitProcess(0)
    displaySelectedOperation(backOrExit)
}

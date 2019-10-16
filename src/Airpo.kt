/*
*
*/
class Airpo {
    val name = "International Airport"
    private val airplanes: List<Airpl> = createAirplanes()

    private fun createAirplanes(): List<Airpl> {
        val airplanes = mutableListOf<Airpl>()
        for (i in 0..3) {
            airplanes.add(Airpl(i))
        }
        return airplanes
    }

    fun forEachAirplane(f: (airplane: Airpl) -> Unit) = airplanes.forEach(f)

    fun getAirplaneById(airplaneId: Int): Airpl? = airplanes.find { it.id == airplaneId }
}

fun Airpo.displayAirplanesId() = forEachAirplane { "Id = ${it.id}".print() }
fun Airpo.displayAirplanesMaxCapacity() = forEachAirplane { "max capacity = ${it.maxCapacity}".print() }
fun Airpo.displayAirplanesCurrentCapacity() = forEachAirplane { "current capacity = ${it.currentCapacity}".print() }
fun Airpo.displayAirplanesAvailableSeats() = forEachAirplane { "available setas = ${it.availableSeats}".print() }
fun Airpo.addPassengers(airplaneId: Int, passengersQuantity: Int) =
        getAirplaneById(airplaneId)?.addPassenger(passengersQuantity)?.print() ?: "No airplane for that id".print()
fun Airpo.removePassengers(airplaneId: Int, passengersQuantity: Int) =
        getAirplaneById(airplaneId)?.removePassenger(passengersQuantity)?.print() ?: "No airplane for that id".print()
fun Airpo.displayAirplaneInfoById(airplaneId: Int) =
        getAirplaneById(airplaneId)?.toString()?.print() ?: "No airplane for that id".print()

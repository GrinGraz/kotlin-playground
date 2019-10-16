package airport

class Airport {
    val name = "International Airport"
    private val airplanes: List<Airplane> = createAirplanes()

    private fun createAirplanes(): List<Airplane> {
        val airplanes = mutableListOf<Airplane>()
        for (i in 0..3) {
            airplanes.add(Airplane(i))
        }
        return airplanes
    }

    private fun getAirplaneById(airplaneId: Int): Airplane? = airplanes.find { it.id == airplaneId }

    private fun forEachAirplane(f: (airplane: Airplane) -> Unit) = airplanes.forEach(f)

    fun displayAirplanesId() = forEachAirplane { "Id = ${it.id}".print() }

    fun displayAirplanesMaxCapacity() = forEachAirplane { "max capacity = ${it.maxCapacity}".print() }

    fun displayAirplanesCurrentCapacity() = forEachAirplane { "current capacity = ${it.currentCapacity}".print() }

    fun displayAirplanesAvailableSeats() = forEachAirplane { "available setas = ${it.availableSeats}".print() }

    fun displayAddPassengers(airplaneId: Int, passengersQuantity: Int) =
            getAirplaneById(airplaneId)?.addPassenger(passengersQuantity)?.print() ?: "No airplane for that id".print()

    fun displayRemovePassengers(airplaneId: Int, passengersQuantity: Int) =
            getAirplaneById(airplaneId)?.removePassenger(passengersQuantity)?.print() ?: "No airplane for that id".print()

    fun displayAirplaneInfoById(airplaneId: Int) =
            getAirplaneById(airplaneId)?.toString()?.print() ?: "No airplane for that id".print()
}

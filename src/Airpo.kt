/*
*
*/
class Airpo{
    val name = "International Airport"
    private val airplanes: List<Airpl>

    init { this.airplanes = createAirplanes() }

    private fun createAirplanes(): List<Airpl> {
        val airplanes = mutableListOf<Airpl>()
        for (i in 0..3) {
            airplanes.add(Airpl(i))
        }
        return airplanes
    }

    fun forEachAirplane(f: (airplane: Airpl) -> Unit) = airplanes.forEach(f)

    fun getAirplaneById(i: Int) : Airpl? = airplanes.find { it.id == i }
}

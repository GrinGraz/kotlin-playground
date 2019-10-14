import java.util.Random

/*
* data class keywords automatically generate toString(), hashCode() and equals() implementations
* By default class properties are public, constructor can hold default values for them.
*/
data class Airpl(
        val id: Int = -1,
        val maxCapacity: Int = generateRandomIntIntRange(10, 20),
        val currentCapacity: Int = generateRandomIntIntRange(1, 10),
        val state: Boolean = Random().nextBoolean())

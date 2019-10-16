import java.util.Random

/*
* data class keywords automatically generate toString(), hashCode() and equals() implementations
* By default class properties are public, constructor can hold default values for them.
*/
data class Airpl(
        val id: Int = -1,
        val maxCapacity: Int = generateRandomIntIntRange(10, 20),
        var currentCapacity: Int = generateRandomIntIntRange(1, 10),
        val state: Boolean = Random().nextBoolean())


fun Airpl.removePassenger(quantity: Int): String {
    if (currentCapacity == 0)
        return "Imposible to remove, current capacity is 0"

    if (currentCapacity - quantity < 0)
        return "Current passengers are " + currentCapacity + " Imposible to remove " + (quantity - currentCapacity) + " passengers"

    this.currentCapacity =+ quantity

    return "Removed $quantity passengers, $currentCapacity passengers left"
}

fun Airpl.addPassenger(quantity: Int): String {
    if (currentCapacity == maxCapacity)
        return "Imposible to add $quantity passenger, max capacity is $maxCapacity, current passengers are $currentCapacity"

    if (currentCapacity + quantity > maxCapacity)
        return "Max capacity is " + maxCapacity + " Imposible to add " + (quantity + currentCapacity - maxCapacity) + " passengers"

    this.currentCapacity =+ quantity

    return "Added $quantity passengers, now are $currentCapacity passengers"
}

val Airpl.availableSeats
    get() = maxCapacity - currentCapacity

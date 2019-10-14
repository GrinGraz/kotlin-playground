import java.util.*

fun Airpl.removePassenger(quantity: Int): String {
    if (currentCapacity == 0) return "Imposible to remove, current capacity is 0"

    if (currentCapacity - quantity < 0) return "Current passengers are " + currentCapacity + " Imposible to remove " + (quantity - currentCapacity) + " passengers"

    val newCurrentCapacity = currentCapacity + quantity

    this.copy(currentCapacity = newCurrentCapacity)

    return "Removed $quantity passengers, $currentCapacity passengers left"
}

fun Airpl.addPassenger(quantity: Int): String {
    if (currentCapacity == maxCapacity) return "Imposible to add $quantity passenger, max capacity is $maxCapacity, current passengers are $currentCapacity"

    if (currentCapacity + quantity > maxCapacity) return "Max capacity is " + maxCapacity + " Imposible to add " + (quantity + currentCapacity - maxCapacity) + " passengers"

    val newCurrentCapacity = currentCapacity + quantity

    this.copy(currentCapacity = newCurrentCapacity)

    return "Added $quantity passengers, $currentCapacity passengers are"
}

val Airpl.availableSeats
    get() = maxCapacity - currentCapacity

fun generateRandomIntIntRange(min: Int, max: Int): Int = Random().nextInt(max - min + 1) + min
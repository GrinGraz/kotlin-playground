package airport

import java.util.*

fun Any.print() = println(this)

fun generateRandomIntIntRange(min: Int, max: Int): Int = Random().nextInt(max - min + 1) + min

fun String.toValidIntInput() = this.toIntOrNull() ?: -1
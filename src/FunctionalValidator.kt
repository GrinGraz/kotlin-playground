val data = hashMapOf(
        "" to 40,
        "tony" to 1,
        "mario" to 60,
        "ron" to 50,
        "default" to 70
)

val isNumber: (value: Any) -> Boolean = { value ->
    when(value) {
        is Number -> true
        else -> false
    }
}

val greaterOrEqualTo: (score: Int, goal: Int) -> Boolean = { score, goal -> score >= goal }

val validScore: (value: Int) -> Boolean  = { value ->  isNumber(value) && greaterOrEqualTo(value, 70) }

fun checkScores(){
    for ((key, value) in data){
        if (key.length > 3) println("$key has pass: ${validScore(value)}")
    }
}
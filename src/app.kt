import kotlin.math.PI
import kotlin.math.pow
import kotlin.system.measureTimeMillis

fun main() {
    val test = Test()
    //test.calcArea()
    //optionFun()
    //optionNone()

    //abstractFactoryOperations2()

    val executionTime = measureTimeMillis {
        curryOperations()
    }

    println(executionTime)

    //val standardOrder = ChargeManagement.getChargeCalculator(Level.STANDARD)

    //println(standardOrder(Order(10)))

    //val listx = listOf<Int>(0..100)

    //val arr = IntArray(999) { i -> i + 1 }
    //createPopulatedIntArray(999).sumMultiplesOfFiveOrThree()

    /*var count = 0
    IntArray(999) { i -> i + 1 }.forEach {
        when (it.rem(5) == 0 || it.rem(3) == 0) {
            true -> count += it
        }
    }
    println("count is $count")*/

    /*var sum = 0
    for (n in 0..999) {
        when (n.rem(5)  n.rem(3)) {
            true -> sum += n
        }
    }
    println(sum)*/

    //println((1..999).filter { it.rem(5) == 0 || it.rem(3) == 0 }.sum())
    //var fibos = listOf(0)
    /*println((1..33).forEachIndexed{ index, i ->
        fibos += when(i){
            0 -> 1
            1 -> 1
            else -> fibos[index] + fibos[index - 1]
        }
    }.also { if (fibos.last() > 4_000_000) println(fibos.filter { element -> element.rem(2) == 0 }.sum()) })*/

    /*println((1..33).forEachIndexed{ index, i ->
        fibos += if (i == 1) i
        else fibos[index] + fibos[index - 1]
    }.also { if (fibos.last() > 4_000_000) println(fibos.filter { it.rem(2) == 0 }.sum()) })

    println(fibos)*/

    //val asdf = Asdf(null)

    //println(measureTimeMillis { arr.forEach { println("- $it") } })

    //arr.fold(0){acc, i ->  }

    //println(arr.toString()

    //val onetomil = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).fold(0) { acc, next -> acc + next }
    //println(onetomil)
}

enum class Level { STANDARD, VIP }

class ChargeManagement {

    companion object {
        fun getChargeCalculator(level: Level): (Order) -> Double {
            return when (level) {
                Level.VIP -> ::premiumOrder
                Level.STANDARD -> ::standardOrder
            }
        }
    }
}

private fun IntArray.sumMultiplesOfFiveOrThree(): Int {

    var multiplesSum = 0

    this.forEach {
        when (it.rem(5) == 0 || it.rem(3) == 0) {
            true -> {
                multiplesSum += it
            }
        }
    }

    return multiplesSum
}

private fun createPopulatedIntArray(amount: Int) = IntArray(amount) { i -> i + 1 }


fun standardOrder(order: Order): Double {
    return order.quantity * 1.2
}

fun premiumOrder(order: Order): Double {
    return order.quantity * 0.8
}

class Order(val quantity: Int)

interface Shape<T> {
    fun area(shape: T): Double
}

data class Circle(val radius: Double)
data class Rectangle(val width: Double, val length: Double)

object CircleShape : Shape<Circle> {
    override fun area(shape: Circle): Double = PI * shape.radius.pow(2)
}

object RectangleShape : Shape<Rectangle> {
    override fun area(shape: Rectangle): Double = shape.width * shape.length
}

fun <T> areaOf(shape: T, shapeImp: Shape<T>): Double = shapeImp.area(shape)

class Test {
    fun calcArea() {
        println(areaOf(Circle(10.0), CircleShape))
        println(areaOf(Rectangle(5.0, 5.0), RectangleShape))
    }
}
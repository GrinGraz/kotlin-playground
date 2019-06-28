// regular 3-ary function expression
val add: (Int, Int, Int) -> Int = { x, y, z -> x + y + z }

// curry function expression which can be partially applied, namely it can returns
// it value in any point based in the number of passed parameters
val curryAdd: (p1: Int) -> (p2: Int) -> (p3: Int) -> Int = { x -> { y -> { z -> x + y + z } } }

// 3-ary parameter function type extension function to transform it to two 1-ary
// function that returns a function which has an integer parameter and one which
// has an integer parameter and returns an integer value
fun <P1, P2, P3, R> ((P1, P2, P3) -> R).curried(): (P1) -> (P2) -> (P3) -> R {
    return { p1: P1 -> { p2: P2 -> { p3: P3 -> this(p1, p2, p3) } } }
}

// the signature of the function changes from 3-ary to curry, totally
// interchangeable with curryAdd
val curriedAdd = { x: Int, y: Int, z: Int -> x + y + z }.curried()

// example of regular and curry functions
fun curryOperations() {
    // it returns the sum of parameters.
    val a = add(1, 2, 3)
    //println("a=$a") // a = 6

    // it will return sum result.
    val b = curriedAdd(1)(2)(3)
    //println("b=$b") // b = 6

    // this will return a 1-ary integer function that returns a 1-ary integer function
    // that returns an integer due the lack of two parameters
    val c = curryAdd(1)
    //println("c=$c")  // c = (Int) -> (Int) -> Int

    // here the function is partially applied and saved it value
    val x = curriedAdd(1) // x: (Int) -> (Int) -> Int
    val y = x(2) // y: (Int) -> Int
    val z = y(3) // z: Int
    //println("z=$z") // z = 6
}

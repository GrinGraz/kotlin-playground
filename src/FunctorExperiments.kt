// create a sealed class Option that model the presence and absence of values
sealed class Option<out A>{
    object None : Option<Nothing>()
    data class Some<out A>(val value: A) : Option<A>()

    // This class become a Functor creating a map function
    // it can be use to apply a function over a value when it is present
    inline infix fun <B> map(f: (A) -> B): Option<B> = when (this) {
        is None -> this
        is Some -> Some(f(value))
    }
}

fun addThree(x: Int) = x + 3

fun optionFun() = println(Option.Some(2) map { addThree(5) + it })

fun optionNone() = println(Option.None map { addThree(2) })
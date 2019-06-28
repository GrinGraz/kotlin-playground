package com.schibsted.scm.nextgenapp.presentation.myaccount


interface one
interface two
interface three

typealias onetwothree = one

open class PartialFeatureView(data: Any, rules: Any)

open class FeatureView(data: Any, rules: Any) {

    val map = mutableMapOf<String, PartialFeatureView2>()

    val getPartialViewBy = { name: String -> when(name){
        "header" -> Counters(data)
        "counter" -> Counters(data)
        else -> null
    }}

    val addPartialView =
            { partialView: PartialFeatureView2 -> map.put("header", partialView) }
}

fun <P1, P2, R> ((P1, P2) -> R).curried(): (P1) -> (P2) -> R {
    return { p1: P1 -> { p2: P2 -> this(p1, p2) } }
}

/*class MyAccount: PartialFeatureView(10, Any())
class HeaderView2(data: Any, rules: Any): PartialFeatureView(data, rules)
class CounterView2(): PartialFeatureView(10, Any())
class MyAdsView2(): PartialFeatureView(10, Any())
class MySearchesView2(): PartialFeatureView(10, Any())
class MySalesView2(): PartialFeatureView(10, Any())*/

sealed class PartialFeatureView2()
sealed class FeatureView2(){

    val map = mutableMapOf<String, PartialFeatureView2>()

    val addPartialView =
            { partialView: PartialFeatureView2 -> map.put("", partialView) }

    val getPartialView = { name: String -> when(name){
        "header" -> map[name]
        "counter" -> map[name]
        else -> null
    }}
}

class MyAccount: FeatureView2()
data class Header(val data: Any): PartialFeatureView2()
data class Counters(val data: Any): PartialFeatureView2()
data class MyAds(val data: Any): PartialFeatureView2()
data class MySearches(val data: Any): PartialFeatureView2()
data class MySales(val data: Any): PartialFeatureView2()

fun asdf(){
    val myAccount = MyAccount()
    myAccount.addPartialView(Header(""))
    myAccount.getPartialView("Header")
}

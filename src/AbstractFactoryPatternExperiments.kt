/* INTERFACES */
interface PartialFeatureView {
    val name: String
    fun makeFeature()
}

interface MyAccountFeatureView : PartialFeatureView

interface PartialFeatureViewFactory {
    fun getFeatureView(name: String): PartialFeatureView
}

/* FACTORY */
class MyAccountPartialFeatureViewFactory : PartialFeatureViewFactory {

    private val map = mutableMapOf<String, MyAccountFeatureView>()

    override fun getFeatureView(name: String): PartialFeatureView {
        return when (name) {
            "header" -> map.getOrPut("header") { Header() }
            "counter" -> map.getOrPut("counter") { Counter() }
            else -> Header()
        }
    }

    private inner class Header : MyAccountFeatureView {
        override val name: String
            get() = "header"

        override fun makeFeature() {
            println("do a lot of header stuff")
        }
    }

    private inner class Counter : MyAccountFeatureView {
        override val name: String
            get() = "counters"

        override fun makeFeature() {
            println("do a lot of counter stuff")
        }
    }
}

fun makeFeatureView(factory: PartialFeatureViewFactory, name: String): PartialFeatureView {
    return factory.getFeatureView(name)
}

fun abstractFactoryOperations() {
    val myAdsFeatureViewFactory = MyAccountPartialFeatureViewFactory()
    val headerView = makeFeatureView(myAdsFeatureViewFactory, "header")
}

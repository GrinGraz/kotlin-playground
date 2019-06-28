import kotlin.system.measureTimeMillis

interface FeatView

class MyAccount() : FeatView {
    val myAccountFeatureViewFactory = MyAccountPartialFeatureViewFactory()
}

class MySales : FeatView

abstract class FeatViewFactory {
    abstract fun makeFeatView(): FeatView

    companion object {
        inline fun <reified T : FeatView> createFactory(): FeatViewFactory = when (T::class) {
            MyAccount::class -> MyAccountFeatViewFactory()
            MySales::class -> MySalesFeatViewFactory()
            else -> MyAccountFeatViewFactory()
        }
    }


}

class MyAccountFeatViewFactory : FeatViewFactory() {
    override fun makeFeatView(): FeatView = MyAccount()
}

class MySalesFeatViewFactory : FeatViewFactory() {
    override fun makeFeatView(): FeatView = MySales()
}

fun abstractFactoryOperations2() {
    val executionTime = measureTimeMillis {

        val featViewFactory = FeatViewFactory.createFactory<MyAccount>()

        val featView = featViewFactory.makeFeatView() as MyAccount

        val header = featView.myAccountFeatureViewFactory.getFeatureView("header")

        header.makeFeature()
    }

    println(executionTime)

}
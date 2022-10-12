package pl.bachorski.designpatterns.creational.factoryMethod

abstract class FMCreator {
    private lateinit var product: FMProduct

    abstract fun factoryMethod(): FMProduct

    fun operation() {
        product = factoryMethod()
    }
}

class FMCreator1 : FMCreator() {
    override fun factoryMethod() = FMProduct1()
}

class FMCreator2 : FMCreator() {
    override fun factoryMethod() = FMProduct2()
}

interface FMProduct {
    fun getName(): String
}

class FMProduct1 : FMProduct {
    override fun getName() = "FMProduct1"
}

class FMProduct2 : FMProduct {
    override fun getName() = "FMProduct2"
}


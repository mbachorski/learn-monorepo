package pl.bachorski.designpatterns.creational.abstractFactory

class Client(private val factory: AbstractFactory) {
    private var productA: ProductA = factory.createProductA()
    private var productB: ProductB = factory.createProductB()

    fun operation(): String = "Result: ${productA.getName()} + ${productB.getName()}"
}

interface ProductA {
    fun getName(): String
}

interface ProductB {
    fun getName(): String
}

interface AbstractFactory {
    fun createProductA(): ProductA
    fun createProductB(): ProductB
}

class ProductA1 : ProductA {
    override fun getName(): String {
        return "Product_A1"
    }
}

class ProductA2 : ProductA {
    override fun getName(): String {
        return "Product_A2"
    }
}

class ProductB1 : ProductB {
    override fun getName(): String {
        return "Product_B1"
    }
}

class ProductB2 : ProductB {
    override fun getName(): String {
        return "Product_B2"
    }
}

class Factory1 : AbstractFactory {
    override fun createProductA(): ProductA = ProductA1()
    override fun createProductB(): ProductB = ProductB1()
}

class Factory2 : AbstractFactory {
    override fun createProductA(): ProductA = ProductA2()
    override fun createProductB(): ProductB = ProductB2()
}
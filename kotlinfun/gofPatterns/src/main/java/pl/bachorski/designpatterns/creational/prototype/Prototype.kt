package pl.bachorski.designpatterns.creational.prototype;

interface Prototype {
    fun clone(): Prototype
}

interface PProduct {
    fun getName(): String
}

data class PProduct1(private val name: String) : PProduct, Prototype {
    override fun getName() = name
    override fun clone() = this.copy()
}

class PProduct2 : PProduct, Prototype {
    override fun getName() = "PProduct2"
    override fun clone() = PProduct2()

    override fun equals(other: Any?): Boolean {
        return other is PProduct2
    }
}
package pl.bachorski.designpatterns.structural.adapter

/**
 * Convert the interface of a class into another interface clients expect.
 * Adapter lets classes work together that couldn't otherwise because of
 * incompatible interfaces.
 */
interface Target {
    fun operation(): String
}

class Adapter(private val adaptee: Adaptee) : Target {
    override fun operation(): String {
        println("Adapter::operation()")
        return adaptee.specificOperation()
    }
}

class Adaptee {
    fun specificOperation() = "Adaptee::adaptedOperation()"
}

class AdapterClient(private val adapter: Target) {
    fun run(): String = adapter.operation()
}
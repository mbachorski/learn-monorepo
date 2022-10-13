package pl.bachorski.designpatterns.structural.adapter

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
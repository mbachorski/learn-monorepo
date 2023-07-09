package pl.bachorski.designpatterns.structural.bridge

/**
 * Decouple an abstraction from its implementation so that the two can vary independently
 */
/**
 * For example, a reusable application that supports different hardware environments.
 * To make an application portable across different hardware environments, it should be possible
 * to select the appropriate hardware-specific implementation at run-time.
 */
/**
 * This is like adapter but we don't call Adaptee class instance in the end,
 * but instead there is an interface and we call instance of this interface.
 */
interface BAbstraction {
    fun operation(): String
}

interface BImplementor {
    fun operationImpl(): String
}

class BImplementor1 : BImplementor {
    override fun operationImpl() = "BImplementor1::operation()"
}

class BAbstraction1(private val bImplementor: BImplementor) : BAbstraction {
    override fun operation() = bImplementor.operationImpl()
}

class BridgeClient(private val bridgeBAbstraction: BAbstraction) {
    fun run() = bridgeBAbstraction.operation()
}
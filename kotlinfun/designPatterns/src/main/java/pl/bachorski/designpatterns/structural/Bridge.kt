package pl.bachorski.designpatterns.structural

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
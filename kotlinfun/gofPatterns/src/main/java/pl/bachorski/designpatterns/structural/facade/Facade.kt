package pl.bachorski.designpatterns.structural.facade


interface Facade {
    fun operation()
}

class FacadeImpl(
    private val class1: Class1,
    private val class2: Class2,
    private val class3: Class3
) : Facade {
    override fun operation() {
        class1.operation1()
        class2.operation2()
        class3.operation3()
    }
}

class Class1 {
    fun operation1() = println("operation_1")
}

class Class2 {
    fun operation2() = println("operation_2")
}

class Class3 {
    fun operation3() = println("operation_3")
}


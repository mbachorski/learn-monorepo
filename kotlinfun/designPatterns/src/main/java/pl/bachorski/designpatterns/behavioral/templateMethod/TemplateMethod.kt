package pl.bachorski.designpatterns.behavioral.templateMethod

abstract class TemplateMethod {
    fun templateMethod() {
        operation1()
        operation2()
    }

    protected abstract fun operation1()

    protected abstract fun operation2()
}

class TMSubClass1 : TemplateMethod() {
    override fun operation1() {
        println("SubClass1 - OPERATION 1")
    }

    override fun operation2() {
        println("SubClass1 - OPERATION 2")
    }
}

class TMSubClass2 : TemplateMethod() {
    override fun operation1() {
        println("SubClass2 - OPERATION 1")
    }

    override fun operation2() {
        println("SubClass2 - OPERATION 2")
    }
}
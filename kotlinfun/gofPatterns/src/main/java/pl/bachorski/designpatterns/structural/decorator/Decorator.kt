package pl.bachorski.designpatterns.structural.decorator

// https://www.baeldung.com/kotlin/decorator-pattern

interface DComponent {
    fun decorate(): String
}

class DDComponent1 : DComponent {
    override fun decorate() = "Component1"
}

abstract class Decorator(private val DComponent: DComponent) : DComponent {
    override fun decorate() = DComponent.decorate()
}

class Decorator1(private val DComponent: DComponent) : Decorator(DComponent) {
    override fun decorate(): String {
        return super.decorate() + addDecoration()
    }

    private fun addDecoration() = "decorator1"
}

class Decorator2(private val DComponent: DComponent) : Decorator(DComponent) {
    override fun decorate(): String {
        return super.decorate() + addDecoration()
    }

    private fun addDecoration() = "decorator2"
}

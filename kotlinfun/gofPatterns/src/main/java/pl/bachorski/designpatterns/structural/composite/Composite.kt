package pl.bachorski.designpatterns.structural.composite

interface Component {
    fun sumChildren(): Int // operation on UML
    fun add(component: Component)
    fun remove(component: Component)
    fun getChildren(): List<Component>
}

class Leaf(private val value: Int) : Component {
    override fun sumChildren(): Int {
        println("Leaf::operation() $value")
        return value
    }

    override fun add(component: Component) {
        throw UnsupportedOperationException("Leaf can not add children")
    }

    override fun remove(component: Component) {
        throw UnsupportedOperationException("Leaf can not remove children")
    }

    override fun getChildren(): List<Component> {
        throw UnsupportedOperationException("Leaf does not have children")
    }
}

class Composite : Component {

    private val components = ArrayList<Component>()

    override fun sumChildren() = components
        .sumOf { it.sumChildren() }
        .also { println("Sum of my leafs is: $it") }


    override fun add(component: Component) {
        components.add(component)
    }

    override fun remove(component: Component) {
        components.remove(component)
    }

    override fun getChildren() = components

}
package pl.bachorski.designpatterns.behavioral.mediator

abstract class Colleague(private val mediator: Mediator) {
    abstract var myState: String
}

// Define an object that encapsulates how a set of objects interact.
// Mediator promotes loose coupling by keeping objects from referring to each other explicitly,
// and it lets you vary their interaction independently.
class Mediator {

    lateinit var colleague1: Colleague1
    lateinit var colleague2: Colleague2

    fun mediate(colleague: Colleague) {
        println("Mediator  : Mediating the interaction ...")
        // Message from colleague1 that its state has changed.
        if (colleague == colleague1) {
            // Performing an action on colleague2.
            val state = colleague1.myState
            colleague2.action2(state)
        } else if (colleague == colleague2) {
            // Performing an action on colleague1.
            val state = colleague2.myState
            colleague1.action1(state)
        }
    }
}

class Colleague1(private val mediator: Mediator) : Colleague(mediator) {
    override var myState: String = ""
        set(value) {
            if (field != value) {
                field = value
                println("Colleague1: My state changed to: $field  Calling my mediator ...")
                mediator.mediate(this)
            }
        }

    fun action1(state: String) {
        myState = state
        println("Colleague1: My state synchronized to $myState")
    }
}

class Colleague2(private val mediator: Mediator) : Colleague(mediator) {
    override var myState: String = ""
        set(value) {
            if (field != value) {
                field = value
                println("Colleague2: My state changed to: $field  Calling my mediator ...")
                mediator.mediate(this)
            }
        }

    fun action2(state: String) {
        myState = state
        println("Colleague2: My state synchronized to $myState")
    }
}
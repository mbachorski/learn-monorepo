package pl.bachorski.designpatterns.behavioral.memento

// Without violating encapsulation, capture and externalize an object's internal state so
// that the object can be restored to this state later

interface State {
    val value: Int
}

data class State1(override val value: Int) : State


class Originator(var state: State) {

    data class Memento(val state: State)

    fun createMemento() = Memento(state)

    fun restore(memento: Memento) {
        this.state = memento.state
    }
}
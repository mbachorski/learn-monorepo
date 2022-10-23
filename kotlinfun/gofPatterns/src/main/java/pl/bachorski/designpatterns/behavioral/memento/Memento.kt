package pl.bachorski.designpatterns.behavioral.memento

interface State {
    val value: Int
}

data class State1(override val value: Int) : State

data class Memento(val state: State)

class Originator(var state: State) {

    fun createMemento() = Memento(state)

    fun restore(memento: Memento) {
        this.state = memento.state
    }
}
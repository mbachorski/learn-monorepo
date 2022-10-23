package pl.bachorski.designpatterns.behavioral.iterator

// Provide a way to access the elements of an aggregate object sequentially
// without exposing its underlying representation

interface Aggregate<E> {
    fun createIterator(): Iterator<E>
    fun add(element: E)
}

interface Iterator<E> {
    fun next(): E
    fun hasNext(): Boolean
}

class Iterator1<E>(private val items: List<E>) : Iterator<E> {

    private var index = -1

    override fun next(): E {
        if (++index < items.size)
            return items[index]
        else throw IndexOutOfBoundsException()
    }

    override fun hasNext(): Boolean {
        return index + 1 < items.size
    }
}

class Aggreagate1<E>() : Aggregate<E> {

    private var items = mutableListOf<E>()

    override fun createIterator(): Iterator<E> {
        return Iterator1<E>(items)
    }

    override fun add(element: E) {
        items.add(element)
    }

}
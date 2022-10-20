package pl.bachorski.designpatterns.structural.proxy

// Provide a surrogate or placeholder for another object
// to control access to it.

interface Subject {
    fun operation()
}

class Proxy(private val realSubject: Subject) : Subject {
    var canAccess = false

    override fun operation() {
        // here access control can take place
        if (canAccess) realSubject.operation()
    }
}

class RealSubject : Subject {
    override fun operation() {
        println("RealSubject::operation()")
    }
}




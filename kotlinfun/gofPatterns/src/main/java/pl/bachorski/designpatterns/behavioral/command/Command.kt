package pl.bachorski.designpatterns.behavioral.command

// Encapsulate a request as an object, thereby letting you parameterize clients with different
// requests, queue or log requests, and support undoable operations.
interface Command {
    fun execute()
}

class Receiver1 {
    fun action1() {
        println("Receiver1::action1()")
    }
}

class Command1(private val receiver: Receiver1) : Command {
    override fun execute() {
        println("Command1::execute()")
        receiver.action1()
    }
}


class Invoker(private val command: Command) {
    fun operation() {
        println("Invoker::operation() -> Calling execute on command")
        command.execute()
    }
}
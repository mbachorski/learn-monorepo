package pl.bachorski.designpatterns.behavioral

import io.mockk.mockk
import io.mockk.verify
import org.junit.Test
import pl.bachorski.designpatterns.behavioral.command.Command
import pl.bachorski.designpatterns.behavioral.command.Command1
import pl.bachorski.designpatterns.behavioral.command.Invoker
import pl.bachorski.designpatterns.behavioral.command.Receiver1

class CommandUnitTest {
    @Test
    fun `Should run operation as command`() {
        // given
        val receiver1: Receiver1 = mockk(relaxed = true)
        val command1: Command = Command1(receiver1)
        val invoker = Invoker(command1)

        // when
        invoker.operation()

        // then
        verify(exactly = 1) { receiver1.action1() }
    }
}
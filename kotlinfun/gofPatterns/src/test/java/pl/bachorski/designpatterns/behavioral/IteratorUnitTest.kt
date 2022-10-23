package pl.bachorski.designpatterns.behavioral

import com.google.common.truth.Truth.assertThat
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test
import pl.bachorski.designpatterns.behavioral.command.Command
import pl.bachorski.designpatterns.behavioral.command.Command1
import pl.bachorski.designpatterns.behavioral.command.Invoker
import pl.bachorski.designpatterns.behavioral.command.Receiver1
import pl.bachorski.designpatterns.behavioral.iterator.Aggreagate1

class IteratorUnitTest {
    @Test
    fun `Should run operation as command`() {
        // given
        val aggreagate1 = Aggreagate1<String>()
        aggreagate1.add("A")
        aggreagate1.add("B")
        aggreagate1.add("C")

        // when
        val iterator1 = aggreagate1.createIterator()

        // then
        assertThat(iterator1.hasNext()).isTrue()
        assertThat(iterator1.next()).isEqualTo("A")
        assertThat(iterator1.next()).isEqualTo("B")
        assertThat(iterator1.next()).isEqualTo("C")
        assertThat(iterator1.hasNext()).isFalse()
    }
}
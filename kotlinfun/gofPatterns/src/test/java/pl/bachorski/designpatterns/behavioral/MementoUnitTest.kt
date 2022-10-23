package pl.bachorski.designpatterns.behavioral

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import pl.bachorski.designpatterns.behavioral.memento.Originator
import pl.bachorski.designpatterns.behavioral.memento.State1

class MementoUnitTest {
    @Test
    fun `Memento should restore state`() {
        // given initial state and originator
        val state1 = State1(123)
        val state2 = State1(456)
        val originator = Originator(state1)

        // when memento 1 is created from state 1
        val memento1 = originator.createMemento()

        // then originator has value of state 1
        assertThat(originator.state.value).isEqualTo(123)

        // when state 2 is assigned
        originator.state = state2

        // then originator has value of state 2
        assertThat(originator.state.value).isEqualTo(456)

        // when memento 1 of state 1 is restored
        originator.restore(memento1)

        // then originator has its state 1
        assertThat(originator.state.value).isEqualTo(123)
    }
}
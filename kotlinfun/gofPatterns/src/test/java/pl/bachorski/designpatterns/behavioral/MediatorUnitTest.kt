package pl.bachorski.designpatterns.behavioral

import android.util.Log
import com.google.common.truth.Truth.assertThat
import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import pl.bachorski.designpatterns.behavioral.mediator.Colleague1
import pl.bachorski.designpatterns.behavioral.mediator.Colleague2
import pl.bachorski.designpatterns.behavioral.mediator.Mediator
import pl.bachorski.designpatterns.behavioral.strategy.Context
import pl.bachorski.designpatterns.behavioral.strategy.Strategy1
import pl.bachorski.designpatterns.behavioral.strategy.Strategy2


class MediatorUnitTest {
    @Test
    fun `Sample Mediator should synchronize state of colleagues`() {
        // given
        val mediator = Mediator()
        val colleague1 = Colleague1(mediator)
        val colleague2 = Colleague2(mediator)
        mediator.colleague1 = colleague1
        mediator.colleague2 = colleague2

        // when
        colleague1.myState = "TEST1"

        // then
        assertThat(colleague2.myState).isEqualTo("TEST1")
    }
}
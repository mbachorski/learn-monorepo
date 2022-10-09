package pl.bachorski.designpatterns.behavioral

import android.util.Log
import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import pl.bachorski.designpatterns.behavioral.strategy.Context
import pl.bachorski.designpatterns.behavioral.strategy.Strategy1
import pl.bachorski.designpatterns.behavioral.strategy.Strategy2


class StrategyUnitTest {
    @Before
    fun setup() {
        mockkStatic(Log::class)
        every { Log.v(any(), any()) } returns 0
    }

    @Test
    fun `Strategy should use different algorithms`() {
        // given
        val context = Context(Strategy1())

        // when
        context.algorithm()

        // then
        // strategy 1 prints Android log
        verify(exactly = 1) { Log.v(any(), any()) }

        // when strategy is dynamically changed
        context.strategy = Strategy2()
        context.algorithm()

        // then strategy 2 prints on console instead of log
    }
}
package pl.bachorski.designpatterns.structural

import com.google.common.truth.Truth.assertThat
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test
import pl.bachorski.designpatterns.structural.facade.*
import pl.bachorski.designpatterns.structural.flyweight.FlyweightFactory


class FacadeUnitTest {
    @Test
    fun `Should call methods hidden by facade`() {
        // given
        val class1 = mockk<Class1>(relaxed = true)
        val class2 = mockk<Class2>(relaxed = true)
        val class3 = mockk<Class3>(relaxed = true)

        val facade: Facade = FacadeImpl(class1, class2, class3)

        // when
        facade.operation()

        // then
        verify(exactly = 1) { class1.operation1() }
        verify(exactly = 1) { class2.operation2() }
        verify(exactly = 1) { class3.operation3() }
    }
}
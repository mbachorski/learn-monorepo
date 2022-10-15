package pl.bachorski.designpatterns.structural

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import pl.bachorski.designpatterns.structural.decorator.DDComponent1
import pl.bachorski.designpatterns.structural.decorator.Decorator1
import pl.bachorski.designpatterns.structural.decorator.Decorator2


class DecoratorUnitTest {
    @Test
    fun `Composite should build hierarchy`() {
        // given
        val dComponent1 = DDComponent1()
        val decorator1 = Decorator1(dComponent1)
        val decorator2 = Decorator2(dComponent1)

        // when
        val resultDecorator1 = decorator1.decorate()
        val resultDecorator2 = decorator2.decorate()

        // then
        assertThat(resultDecorator1).isEqualTo("Component1decorator1")
        assertThat(resultDecorator2).isEqualTo("Component1decorator2")
    }
}
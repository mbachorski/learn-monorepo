package pl.bachorski.designpatterns.creational

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import pl.bachorski.designpatterns.creational.abstractFactory.Client
import pl.bachorski.designpatterns.creational.abstractFactory.Factory1
import pl.bachorski.designpatterns.creational.abstractFactory.Factory2


class AbstractFactoryUnitTest {
    @Test
    fun `Abstract Factory1 should return factory1 objects`() {
        // given
        val factory = Factory1()
        val client = Client(factory)

        // when
        val result = client.operation()

        // then
        assertThat(result).isEqualTo("Result: Product_A1 + Product_B1")
    }

    @Test
    fun `Abstract Factory2 should return factory2 objects`() {
        // given
        val factory = Factory2()
        val client = Client(factory)

        // when
        val result = client.operation()

        // then
        assertThat(result).isEqualTo("Result: Product_A2 + Product_B2")
    }
}
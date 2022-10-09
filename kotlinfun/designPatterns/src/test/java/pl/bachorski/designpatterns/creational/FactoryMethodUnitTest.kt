package pl.bachorski.designpatterns.creational

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import pl.bachorski.designpatterns.creational.factoryMethod.FMCreator1
import pl.bachorski.designpatterns.creational.factoryMethod.FMCreator2


class FactoryMethodUnitTest {
    @Test
    fun `Factory Method should create factory1 object`() {
        // given
        val creator = FMCreator1()
        creator.operation()

        // when
        val product = creator.factoryMethod()

        // then
        assertThat(product.getName()).isEqualTo("FMProduct1")
    }

    @Test
    fun `Factory Method should create factory2 objects`() {
        // given
        val creator = FMCreator2()
        creator.operation()

        // when
        val product = creator.factoryMethod()

        // then
        assertThat(product.getName()).isEqualTo("FMProduct2")
    }
}
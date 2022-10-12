package pl.bachorski.designpatterns.creational

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import pl.bachorski.designpatterns.creational.prototype.PProduct1
import pl.bachorski.designpatterns.creational.prototype.PProduct2


class PrototypeUnitTest {
    @Test
    fun `Prototype should create clones of itself`() {
        // given
        val object1 = PProduct1("object1")
        val object2 = PProduct2()

        // when
        val cloneOfObject1 = object1.clone()
        val cloneOfObject2 = object2.clone()

        // then
        assertThat(object1 == cloneOfObject1).isTrue()
        assertThat(object2 == cloneOfObject2).isTrue()
    }
}
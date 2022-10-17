package pl.bachorski.designpatterns.structural

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import pl.bachorski.designpatterns.structural.flyweight.FlyweightFactory


class FlyweightUnitTest {
    @Test
    fun `Should reuse flyweights`() {
        // given
        val flyweightA1 = FlyweightFactory.getFlyweight("A")
        val flyweightA2 = FlyweightFactory.getFlyweight("A")

        // then
        assert(flyweightA1 === flyweightA2)
    }

    @Test
    fun `Should NOT reuse unshared flyweights`() {
        // given
        val unsharedFlyweight1 = FlyweightFactory.getUnsharedFlyweight()
        val unsharedFlyweight2 = FlyweightFactory.getUnsharedFlyweight()

        // then
        assert(unsharedFlyweight1 !== unsharedFlyweight2)
    }

    @Test
    fun `Should have different extrinsic state`() {
        // given
        val flyweightA1 = FlyweightFactory.getFlyweight("A")

        // when
        val result1 = flyweightA1.operation(123)
        val result2 = flyweightA1.operation(456)

        // then
        assertThat(result1).isNotEqualTo(result2)
    }
}
package pl.bachorski.designpatterns.structural

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import pl.bachorski.designpatterns.structural.composite.Component
import pl.bachorski.designpatterns.structural.composite.Composite
import pl.bachorski.designpatterns.structural.composite.Leaf


class CompositeUnitTest {
    @Test
    fun `Composite should build hierarchy`() {
        // given
        val rootComponent = buildHierarchy()

        // when
        val result = rootComponent.sumChildren()

        // then
        assertThat(result).isEqualTo(15)
    }

    // rootComponent
    // |- leaf1
    // |- composite1
    // |-- leaf2
    // |-- leaf3
    // |- composite2
    // |-- leaf4
    // |-- leaf5
    // SUM OF ALL LEAVES is 15
    private fun buildHierarchy(): Component {
        val leaf1 = Leaf(1)
        val leaf2 = Leaf(2)
        val leaf3 = Leaf(3)
        val leaf4 = Leaf(4)
        val leaf5 = Leaf(5)
        val composite1 = Composite()
        val composite2 = Composite()
        val rootComponent = Composite()

        rootComponent.add(composite1)
        rootComponent.add(composite2)
        rootComponent.add(leaf1)

        composite1.add(leaf2)
        composite1.add(leaf3)

        composite2.add(leaf4)
        composite2.add(leaf5)
        return rootComponent
    }
}
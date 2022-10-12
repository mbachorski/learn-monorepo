package pl.bachorski.designpatterns.behavioral

import org.junit.Test
import pl.bachorski.designpatterns.behavioral.templateMethod.TMSubClass1


class TemplateMethodUnitTest {

    @Test
    fun `Strategy should use different algorithms`() {
        // given
        val subClass1 = TMSubClass1()

        // when
        subClass1.templateMethod()

        // then operation 1 should be printed in console
    }
}
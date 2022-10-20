package pl.bachorski.designpatterns.behavioral

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import pl.bachorski.designpatterns.behavioral.chainOfResponsibility.Handler1
import pl.bachorski.designpatterns.behavioral.chainOfResponsibility.Handler2
import pl.bachorski.designpatterns.behavioral.chainOfResponsibility.Handler3
import pl.bachorski.designpatterns.behavioral.chainOfResponsibility.HandlerResultCallback


class ChainOfResponsibilityUnitTest {
    @Test
    fun `Should process result and skip second handler`() {
        var resultString = ""
        val resultCallback = object : HandlerResultCallback {
            override fun onChainFinishedProcessing(result: String) {
                resultString = result
                println("ChainOfResponsibility::onChainFinishedProcessing(): $result")
            }
        }

        // given
        val handler1 = Handler1(resultCallback)
        val handler2 = Handler2(resultCallback)
        val handler3 = Handler3(resultCallback)

        handler1.successor = handler2
        handler2.successor = handler3
        handler3.successor = null

        // when
        handler1.handleRequest("TEST")

        // then
        assertThat(resultString).isEqualTo("TEST_handler1__handler3_")
    }

}
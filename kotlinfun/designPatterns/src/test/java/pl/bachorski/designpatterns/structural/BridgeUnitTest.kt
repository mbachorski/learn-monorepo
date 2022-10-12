package pl.bachorski.designpatterns.structural

import com.google.common.truth.Truth.assertThat
import org.junit.Test


class BridgeUnitTest {
    @Test
    fun `Prototype should create clones of itself`() {
        // given
        val bridgeImplementor = BImplementor1()
        val bridgeAbstraction = BAbstraction1(bridgeImplementor)
        val bridgeClient = BridgeClient(bridgeAbstraction)

        // when
        val result = bridgeClient.run()

        // then
        assertThat(result).isEqualTo("aa")
    }
}
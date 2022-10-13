package pl.bachorski.designpatterns.structural

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import pl.bachorski.designpatterns.structural.adapter.Adaptee
import pl.bachorski.designpatterns.structural.adapter.Adapter
import pl.bachorski.designpatterns.structural.adapter.AdapterClient
import pl.bachorski.designpatterns.structural.bridge.BAbstraction1
import pl.bachorski.designpatterns.structural.bridge.BImplementor1
import pl.bachorski.designpatterns.structural.bridge.BridgeClient


class AdapterUnitTest {
    @Test
    fun `Prototype should create clones of itself`() {
        // given
        val adaptee = Adaptee()
        val adapter = Adapter(adaptee)
        val adapterClient = AdapterClient(adapter)

        // when
        val result = adapterClient.run()

        // then
        assertThat(result).isEqualTo("Adaptee::adaptedOperation()")
    }
}
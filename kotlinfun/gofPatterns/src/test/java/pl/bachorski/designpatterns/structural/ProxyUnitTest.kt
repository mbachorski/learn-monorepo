package pl.bachorski.designpatterns.structural

import io.mockk.mockk
import io.mockk.verify
import org.junit.Test
import pl.bachorski.designpatterns.structural.proxy.Proxy
import pl.bachorski.designpatterns.structural.proxy.RealSubject


class ProxyUnitTest {
    @Test
    fun `Should access real object`() {
        // given
        val realSubject = mockk<RealSubject>(relaxed = true)
        val proxy = Proxy(realSubject)

        // when
        proxy.canAccess = true
        proxy.operation()

        // then
        verify(exactly = 1) { realSubject.operation() }
    }

    @Test
    fun `Should NOT access real object`() {
        // given
        val realSubject = mockk<RealSubject>(relaxed = true)
        val proxy = Proxy(realSubject)

        // when
        proxy.canAccess = false
        proxy.operation()

        // then
        verify(exactly = 0) { realSubject.operation() }
    }
}
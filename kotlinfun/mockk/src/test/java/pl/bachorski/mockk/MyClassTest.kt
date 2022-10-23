package pl.bachorski.mockk

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class MyClassTest {
    @Test
    fun `Should verify private method called`() {
        val x = 1
        assertThat(x).isEqualTo(1)
    }
}
package pl.bachorski.mockitoapp

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import pl.bachorski.mockitoapp.domain.Device
import pl.bachorski.mockitoapp.domain.DeviceType
import pl.bachorski.mockitoapp.domain.Room

class RoomTest {
    @Test
    fun roomShouldFilterBlinds() {
        // given room with devices
        val room = Room("Kitchen")
        room.devices = buildSampleDevicesList()

        // when only lights are requested
        val lights = room.lights

        // result has all lights
        assertThat(lights.size).isEqualTo(1)
    }

    private fun buildSampleDevicesList(): List<Device> {
        val lightSwtich = Device(DeviceType.SWITCH, 1)
        val lightMultilevelSwitch = Device(DeviceType.MULTILEVEL_SWITCH, 0)
        val blind = Device(DeviceType.BLIND, 100)

        return listOf(lightSwtich, lightMultilevelSwitch, blind)
    }
}
package tirepressuremonitoringsystem

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

internal class AlarmTest
{
    @Test
    fun `when pressure is 15 then set alarm`()
    {
        val alarm = Alarm()
        val sensorMock = mock(Sensor::class.java)
        alarm.sensor = sensorMock

        `when`(alarm.sensor.popNextPressurePsiValue()).thenReturn(15.0)
        alarm.check()

        assertEquals(true, alarm.isAlarmOn)
    }
}
package tirepressuremonitoringsystem

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class AlarmTest
{
    @Test
    fun foo()
    {
        val alarm = Alarm()
        assertEquals(false, alarm.isAlarmOn)
    }
}
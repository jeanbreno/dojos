package tddmicroexercises.tirepressuremonitoringsystem;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TestAlarm {

    @Test
    public void foo() {
        ISensor sensor = mock(ISensor.class);
        Alarm alarm = new Alarm(sensor);
        assertEquals(false, alarm.isAlarmOn());
    }
    
    @Test
    public void checkIfAlarmIsOnByDefault() {
        ISensor sensor = mock(ISensor.class);
        Alarm alarm = new Alarm(sensor);
        assertEquals(false, alarm.isAlarmOn());
    }

    @Test
    public void checkIfAlarmIsOnWithHighPsiPressureValue() {
        ISensor sensor = mock(ISensor.class);
        when(sensor.popNextPressurePsiValue()).thenReturn(Double.valueOf(22));
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertEquals(true, alarm.isAlarmOn());
    }

    @Test
    public void checkIfAlarmIsOnWithLowPsiPressureValue() {
        ISensor sensor = mock(ISensor.class);
        when(sensor.popNextPressurePsiValue()).thenReturn(Double.valueOf(16));
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertEquals(true, alarm.isAlarmOn());
    }

    @Test
    public void checkIfAlarmIsOnWithAllowPsiPressureValue() {
        ISensor sensor = mock(ISensor.class);
        when(sensor.popNextPressurePsiValue()).thenReturn(Double.valueOf(18));
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertEquals(false, alarm.isAlarmOn());
    }
    
}

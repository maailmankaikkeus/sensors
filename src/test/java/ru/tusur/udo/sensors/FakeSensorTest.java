package ru.tusur.udo.sensors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ru.tusur.udo.sensors.emulator.FakeSensor;

public class FakeSensorTest {

	@Test
    public void testSensor()
    {			
		FakeSensor fakeSensor = new FakeSensor();
		assertNotNull(fakeSensor);
		fakeSensor.setSerial("123456");
		fakeSensor.setType("ANALOG");				
		assertEquals(fakeSensor.getValue(), 0);		
		assertEquals(fakeSensor.getType(), "ANALOG");
		assertEquals(fakeSensor.getSerial(), "123456");
		
    }
	
}

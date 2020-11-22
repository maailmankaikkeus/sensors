package ru.tusur.udo.sensors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import ru.tusur.udo.sensors.emulator.DStrategy;
import ru.tusur.udo.sensors.emulator.EmulationStrategy;
import ru.tusur.udo.sensors.emulator.FakeSensor;

public class DStrategyTest {


	@Test
    public void testDStrategy()
    {			
		FakeSensor fakeSensor = new FakeSensor();
		assertNotNull(fakeSensor);
		EmulationStrategy dstrategy = new DStrategy();
		fakeSensor.setEmulationStrategy(dstrategy);		
		
		int etalonValue = 0;
		assertEquals(fakeSensor.getValue(), etalonValue);
		
		for (int i = 0; i < 127887; i++) {
			fakeSensor.emulate();
			if (i % 3 == 0  &&  i != 0) {
				if (etalonValue == 0) {
					etalonValue = 1;
				} else {
					etalonValue = 0;
				}
			}
			assertEquals(fakeSensor.getValue(), etalonValue);
		}				
		
    }

}

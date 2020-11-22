package ru.tusur.udo.sensors.emulator;

public class DStrategy implements EmulationStrategy {

	int ticks;
	
	public void doEmulate(FakeSensor sensor) {		

		if (ticks > 2) {
			ticks = 0;
			if (sensor.getValue() == 0) {
				sensor.setValue(1);
			} else {
				sensor.setValue(0);
			}			
		}
		ticks++;
	}

}

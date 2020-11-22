package ru.tusur.udo.sensors.emulator;

import ru.tusur.udo.sensors.core.Sensor;

public class FakeSensor implements Sensor {
	private EmulationStrategy emulationStrategy;
	
	private int value;
	private String type;
	private String serial;
	
	Sensor toPureSensor() {
		return new Sensor() {

			@Override
			public int getValue() {				
				return value;
			}

			@Override
			public String getType() {				
				return type;
			}

			@Override
			public String getSerial() {
				return serial;
			}
			
		};
	}
	
	public EmulationStrategy getEmulationStrategy() {
		return emulationStrategy;
	}
	
	public void setEmulationStrategy(EmulationStrategy emulationStrategy) {
		this.emulationStrategy = emulationStrategy;
	}
	
	public void emulate() {
		emulationStrategy.doEmulate(this);
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public String getType() {
		return this.type;
	}	
	public void setType(String type) {
		this.type = type;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getSerial() {
		return this.serial;
	}
}

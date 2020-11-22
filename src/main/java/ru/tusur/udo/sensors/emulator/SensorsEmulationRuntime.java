package ru.tusur.udo.sensors.emulator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import ru.tusur.udo.sensors.core.Sensor;
import ru.tusur.udo.sensors.core.SensorRuntime;

@Component
public class SensorsEmulationRuntime extends Thread  
		implements SensorRuntime {
	
	private static Logger LOG = LoggerFactory.getLogger(SensorsEmulationRuntime.class);
	
	@Value("${runtime.interval}")
	private int runtimeInterval;
	
	@Autowired
	private Map<String, FakeSensor> fakeSensors;
	
	public List<Sensor> getSensors() {
		return fakeSensors
				.values()
				.stream()
				.map(f -> f.toPureSensor())
				.collect(Collectors.toList());
	}
	
	public void run() {
		while(true) {
			emulateSensors();
			try {
				sleep(runtimeInterval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void emulateSensors() {
		fakeSensors.forEach((key, value) -> {
			value.emulate();
			//LOG.error(value.getSerial() + " " + value.getValue());
		});
		
	}
			
	
	
	
	
	
}

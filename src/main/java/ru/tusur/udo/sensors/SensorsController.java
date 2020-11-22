package ru.tusur.udo.sensors;

import org.springframework.context.ApplicationContext;

import ru.tusur.udo.sensors.emulator.SensorsEmulationRuntime;

public class SensorsController {
	
	public static void start(ApplicationContext ctx) {		
		Object r = ctx.getBean("sensorsEmulationRuntime");
		if (r instanceof SensorsEmulationRuntime) {
			SensorsEmulationRuntime runtime = (SensorsEmulationRuntime) r;
			runtime.start();
		}
	}
}

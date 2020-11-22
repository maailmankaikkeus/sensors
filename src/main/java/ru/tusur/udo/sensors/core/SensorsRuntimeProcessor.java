package ru.tusur.udo.sensors.core;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SensorsRuntimeProcessor implements Processor  {

	@Autowired
	SensorRuntime sensorRuntime;
	
	@Override
	public void process(Exchange exchange) throws Exception {
		exchange.getIn().setBody(sensorRuntime.getSensors());
	}

}

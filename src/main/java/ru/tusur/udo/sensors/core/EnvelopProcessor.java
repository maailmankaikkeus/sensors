package ru.tusur.udo.sensors.core;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnvelopProcessor implements Processor {

	@Value("${node.name}")
	private String nodeName;
	
	@Override
	public void process(Exchange exchange) throws Exception {

		ArrayList<Sensor> body = exchange.getIn().getBody(ArrayList.class);		 
		 
		 if (body != null && body.size() > 0) {
			 if (body.get(0) instanceof Sensor) {
				 ArrayList<Sensor> sensors  = (ArrayList<Sensor> ) body;
				 exchange.getIn().setBody(new SensorsJSONSchema() {
						
						public String getNode() {
							return nodeName;
						}
						
						public List<Sensor> getSensors() {
							return sensors;
						}
					
					});		 
			 }
		 } else {
			 exchange.getIn().setBody(null);
		 }
		
	}

}

package ru.tusur.udo.sensors.core;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.http4.HttpMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class SensorsRoutes extends RouteBuilder {

	@Value("${polling.interval}")
	String pollingInterval;

	@Value("${app.server.endpoint}")
	String appServerEndopint;
	
	@Autowired
	SensorsRuntimeProcessor sensorsRuntimeProcessor;
	
	@Autowired
	EnvelopProcessor envelopProcessor;
	
	@Autowired
	JSONProcessor jsonProcessor;
	
	@Override
	public void configure() throws Exception {
		
		from("timer://timer?period=" + pollingInterval)
		.process(sensorsRuntimeProcessor)
		.to("direct:envelop");
		
		from("direct:envelop")
		.process(envelopProcessor)
		.to("direct:json");
		
		
		from("direct:json")
		.process(jsonProcessor)		
		.to("direct:senddata");
		
		
		from("direct:senddata")
		.setHeader(Exchange.HTTP_METHOD, constant(HttpMethods.POST))
		.to("http4:" + appServerEndopint)
		.log("${body}");
		
	}

}

package test.springsandbox.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import test.springsandbox.aop.service.TrafficFortuneService;

public class AroundMainApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);

		TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		boolean tripWire = true;
		String data = fortuneService.getFortune(tripWire);
		System.out.println("My fortune is: " + data);
		
		context.close();
	}

}

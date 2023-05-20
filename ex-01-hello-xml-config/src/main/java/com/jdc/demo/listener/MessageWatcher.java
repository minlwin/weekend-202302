package com.jdc.demo.listener;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.jdc.demo.ValueHolder;

@Component
public class MessageWatcher {

	@EventListener
	public void handle(ValueHolder message) {
		System.out.println("Handle Event");
		System.out.println("Message is : %s".formatted(message.getValue()));
	}
	
	@EventListener(value = ContextRefreshedEvent.class)
	public void handleStart() {
		System.out.println("IoC Container is ready to use.");
	}
	
	@EventListener
	public void handle(ContextClosedEvent event) {
		System.out.println("IoC Container will be closed soon.");
	}
}

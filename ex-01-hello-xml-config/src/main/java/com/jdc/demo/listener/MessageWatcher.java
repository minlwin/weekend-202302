package com.jdc.demo.listener;

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
}

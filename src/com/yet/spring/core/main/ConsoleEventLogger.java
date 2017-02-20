package com.yet.spring.core.main;

import com.yet.spring.core.interfaces.EventLogger;

public class ConsoleEventLogger implements EventLogger {

	public void logger(Event event) {
		System.out.println(event);
	}

}

package com.yet.spring.core.main;

import com.yet.spring.core.interfaces.EventLogger;
import com.yet.spring.core.main.*;

public class ConsoleEventLogger implements EventLogger {

	public void logger(com.yet.spring.core.main.Event event) {
		System.out.println(event);
	}

}

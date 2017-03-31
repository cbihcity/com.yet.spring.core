package com.yet.spring.core.main;

import java.util.Collection;

import com.yet.spring.core.interfaces.EventLogger;
import com.yet.spring.core.main.*;

public class CombinedEventLogger implements EventLogger {

	private Collection<EventLogger> loggers;
	
	

	public CombinedEventLogger(Collection<EventLogger> loggers) {
		super();
		this.loggers = loggers;
	}

	@Override
	public void logger(com.yet.spring.core.main.Event event) {
		for (EventLogger eventLogger : loggers) {
			eventLogger.logger(event);
		}
	}

}

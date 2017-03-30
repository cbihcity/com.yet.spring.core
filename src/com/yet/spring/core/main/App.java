package com.yet.spring.core.main;

import java.util.Map;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yet.spring.core.interfaces.EventLogger;

public class App {
	private Event event;
	private EventLogger eventLogger;

	public App() {
		super();
	}

	
	public App(Event event, EventLogger eventLogger) {
		super();
		this.event = event;
		this.eventLogger = eventLogger;
	}


	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public EventLogger getEventLogger() {
		return eventLogger;
	}

	public void setEventLogger(EventLogger eventLogger) {
		this.eventLogger = eventLogger;
	}
	
	private void logEvent(Event event) {

        eventLogger.logger(event);
    }
	
	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		long count = 0;
		App app = ctx.getBean(App.class);
		while (count < 450000) {
			app.event.setMsg("ok");
			app.logEvent(app.getEvent());
			count++;
		}
	}
}

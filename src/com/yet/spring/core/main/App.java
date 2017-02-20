package com.yet.spring.core.main;

import java.util.Map;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yet.spring.core.interfaces.EventLogger;

public class App {
	private Event event;
	private EventLogger eventLogger;
	private Map<EventType, EventLogger> loggers;
	
	public App() {
		super();
	}

	
	public App(Event event, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
		super();
		this.event = event;
		this.eventLogger = eventLogger;
		this.loggers = loggers;
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
	
	private void logEvent(EventType eventType, Event event) {
        
        EventLogger logger = loggers.get(eventType);
       if (logger == null) {
            logger = eventLogger;
        }
        
        logger.logger(event);
    }
	
	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		
				App app = ctx.getBean(App.class);
				app.event.setMsg("ok");
				app.logEvent(EventType.INFO, app.event);
				
				App app1 = ctx.getBean(App.class);
				app1.event.setMsg("ERROR");
				app1.logEvent(EventType.ERROR, app1.event);
			
			
	}
}

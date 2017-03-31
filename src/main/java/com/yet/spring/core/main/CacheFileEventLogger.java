package com.yet.spring.core.main;

import com.yet.spring.core.main.*;
import com.yet.spring.core.main.Event;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends com.yet.spring.core.main.FileEventLogger {

	private int cachesize;
	private List<com.yet.spring.core.main.Event> list;
	
	
	
	public CacheFileEventLogger(String filename, int cachesize) {
		super(filename);
		this.cachesize = cachesize;
		this.list = new ArrayList<com.yet.spring.core.main.Event>(cachesize);
	}

	public void logger(Event event) {
		list.add(event);
		if (list.size() == cachesize ) {
			writeEventsFromCache();
			list.clear();
		}
	}

	private void writeEventsFromCache() {
		list.stream().forEach(super::logger);
	}
	
	public void destroy(){
		if (!list.isEmpty()) {
			writeEventsFromCache();
		}
	}

}

package com.yet.spring.core.main;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {

	private int cachesize;
	private List<Event> list;
	
	
	
	public CacheFileEventLogger(String filename, int cachesize) {
		super(filename);
		this.cachesize = cachesize;
		this.list = new ArrayList<Event>(cachesize);
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

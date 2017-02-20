package com.yet.spring.core.main;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.yet.spring.core.interfaces.EventLogger;

public class FileEventLogger implements EventLogger {
	public String filename;
	private File file;
	public void logger(Event event) {
		try {
			FileUtils.writeStringToFile(file, event.toString() + "\n", true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public FileEventLogger(String filename) {
		this.filename = filename;
	}
	
	public void init(){
		this.file = new File(filename);
	}
	
	
}

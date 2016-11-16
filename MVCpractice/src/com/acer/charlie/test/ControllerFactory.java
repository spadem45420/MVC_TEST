package com.acer.charlie.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class ControllerFactory {
	
	private static IController controller;
	
	public IController getInstance() throws Exception {
		
		String className = this.readSetPropertyClass2();
		
		Class<?> act = null;
		try {
			act = Class.forName(className);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try {
			if(controller == null) {
				controller = (IController) act.newInstance();
			}
			else {
				return controller;
			}
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return controller;
	}
	
	public IController getInstance(String name) {
		
		Class<?> act = null;
		try {
			act = Class.forName(name);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try {
			controller = (IController) act.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return controller;
	}
	
	private String readSetPropertyClass() throws Exception {
		try {
			InputStream inputStream = ControllerFactory.class.getResourceAsStream("controller_setting.xml");
			Properties properties = new Properties();
			properties.loadFromXML(inputStream);
			inputStream.close();

			@SuppressWarnings("rawtypes")
			Enumeration enuKeys = properties.keys();
			
			int count = 0;
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				System.out.println("Properties element = " + key + ": " + value);
				
				count++;
			}
			
			if(count != 0) {
				return (String) properties.get("contoller");
			}
			else {
				throw new Exception("properties loading error");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public String readSetPropertyClass2() {
		Properties properties = new Properties();
		String configFile = "controller_settin.properties";
		try {
		    properties.load(ControllerFactory.class.getResourceAsStream(configFile));
		} catch (FileNotFoundException ex) {
		    ex.printStackTrace();
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
		return (String) properties.get("controller");
	}
	
//	public static void main(String[] args) throws Exception {
//		System.out.println(new ControllerFactory().readSetPropertyClass());
//		System.out.println(new ControllerFactory().readSetPropertyClass2());
//	}
}

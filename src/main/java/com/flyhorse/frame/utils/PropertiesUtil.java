package com.flyhorse.frame.utils;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;


public class PropertiesUtil extends PropertyPlaceholderConfigurer{
	private static Properties properties;
	
	private static String resourcePath;
	private static String downloadPath;
	
	
	public static String getResourcePath() {
		return resourcePath;
	}
	
	public static String getDownloadPath() {
		return downloadPath;
	}
	
	
	@Override
	protected void processProperties(ConfigurableListableBeanFactory cbf,Properties properties) throws BeansException {
		PropertiesUtil.properties = properties;
		
		String resourcePath_temp = properties.getProperty("resourcePath");
		String downloadPath = properties.getProperty("downloadPath");
		
		
		PropertiesUtil.resourcePath = resourcePath_temp;
		PropertiesUtil.downloadPath = downloadPath;
		
		
		super.processProperties(cbf, properties);
	}

	public static String getProperty(String key){
		return properties.getProperty(key);
	}

}
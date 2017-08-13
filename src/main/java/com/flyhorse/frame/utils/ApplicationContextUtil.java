package com.flyhorse.frame.utils;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;
public class ApplicationContextUtil extends ContextLoaderListener{
	private static ApplicationContext applicationContext;
	private static ServletContext servletContext;
	@Override
	public void contextInitialized(ServletContextEvent event) {
		servletContext = event.getServletContext(); 
		super.contextInitialized(event);
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		applicationContext = ctx;
	}
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	public static ServletContext getServletContext() {
		return servletContext;
	}
	public static Object getBean(String id){
		return applicationContext.getBean(id);
	}
	public static Object getSession(String sessionName){
		  ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	      Object obj = servletRequestAttributes.getRequest().getSession().getAttribute(sessionName);
	      return obj;
	}
}
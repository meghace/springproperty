package com.appprops.appprops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
//
@SpringBootApplication
public class ApppropsApplication  {

	private static ConfigurableApplicationContext applicationContext;
	public static String MODE = "";
	public static void main(String[] args) {

		MODE = args[0];
		applicationContext= SpringApplication.run(ApppropsApplication.class, args);

	}
	public static ConfigurableApplicationContext getApplicationContext() {
		return applicationContext;
	}


}

package com.appprops.appprops;

import com.appprops.appprops.config.AppPropertyListener;
import com.appprops.appprops.properties.AppPropertyFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ApppropsApplication  {

	private static ConfigurableApplicationContext applicationContext;
	public static void main(String[] args) {

		AppPropertyFactory.setPropertyType(args[0]);
		applicationContext= SpringApplication.run(ApppropsApplication.class, args);

	}
	public static ConfigurableApplicationContext getApplicationContext() {
		return applicationContext;
	}
}

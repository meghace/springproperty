package com.appprops.appprops.config;

import com.appprops.appprops.properties.AppPropertyFactory;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class AppPropertyListener implements ApplicationListener<ApplicationPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        try{
            ApplicationContext applicationContext = event.getApplicationContext();
            AppPropertyFactory.getAppProperties(applicationContext).postProcessEnvironment();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}

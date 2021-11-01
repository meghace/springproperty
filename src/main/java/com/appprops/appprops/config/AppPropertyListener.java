package com.appprops.appprops.config;

import com.appprops.appprops.properties.AppPropertyFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class AppPropertyListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        AppPropertyFactory.getAppProperties().postProcessEnvironment();
    }
}

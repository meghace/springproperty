package com.appprops.appprops.properties;

import com.appprops.appprops.repo.SettingRepository;
import com.appprops.appprops.model.Setting;
import com.appprops.appprops.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.DeferredLog;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DBProperties implements AppProperties {

    private static final String PROPERTY_SOURCE_NAME = "dbProperties";
    private static final DeferredLog log = new DeferredLog();

    private final ConfigurableEnvironment environment;

    @Autowired
    SettingRepository repository;

    public DBProperties(@Autowired ConfigurableEnvironment environment) {
        this.environment = environment;
    }

    @Override
    public void postProcessEnvironment() {

        Map<String, Object> propertySource = new HashMap<>();
        try {

            List<Setting> list = repository.findAll();
            for (Setting s : list) {
                propertySource.put(s.getKey(),s.getValue());
            }
            propertySource = MapUtil.ProcessValues(propertySource);
            environment.getPropertySources().addFirst
                    (new MapPropertySource(PROPERTY_SOURCE_NAME, propertySource));

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }


}

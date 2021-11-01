package com.appprops.appprops.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Component
public class YAMLProperties implements AppProperties {

    private static final String PROPERTY_SOURCE_NAME = "yamlProperties";
    private final ConfigurableEnvironment environment;

    public YAMLProperties(@Autowired ConfigurableEnvironment environment) {
        this.environment = environment;
    }

    @Override
    public void postProcessEnvironment() {
        Map<String, Object> propertySource = new HashMap<>();

        InputStream is = getClass().getClassLoader().getResourceAsStream("appsettings.yaml");
        Yaml yaml = new Yaml();
        Map<String, Object> data = yaml.load(is);

        for (Map.Entry<String, Object> entry : data.entrySet()) {

            for (Map.Entry<String, Object> entry1 : ((Map<String, Object>) entry.getValue()).entrySet()) {

                propertySource.put(entry.getKey() + "." + entry1.getKey(), entry1.getValue());

            }
            environment.getPropertySources().addFirst
                    (new MapPropertySource(PROPERTY_SOURCE_NAME, propertySource));
        }


    }

}

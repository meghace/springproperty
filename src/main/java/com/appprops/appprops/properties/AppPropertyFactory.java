package com.appprops.appprops.properties;

import com.appprops.appprops.ApppropsApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


public class AppPropertyFactory {
    private static PropertyType propertyType;

    public static AppProperties getAppProperties(ApplicationContext applicationContext) {
        switch (propertyType) {
            case DB:
               return applicationContext.getBean(DBProperties.class);
            case XML:
                return applicationContext.getBean(XMLProperties.class);
            case YML:
                return applicationContext.getBean(YAMLProperties.class);
            default:
                throw new IllegalArgumentException("Property Type Invalid");
        }
    }

    public static void setPropertyType(String propertyType) {
        AppPropertyFactory.propertyType = PropertyType.getPropertyType(propertyType);
    }
}

enum PropertyType {
    DB, XML, YML;

    public static PropertyType getPropertyType(String propertyType) {
        for (PropertyType property : PropertyType.values()) {
            if (property.name().equalsIgnoreCase(propertyType.toUpperCase())) {
                return property;
            }
        }
        return null;
    }
}

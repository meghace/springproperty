package com.appprops.appprops.properties;

import com.appprops.appprops.ApppropsApplication;

public class AppPropertyFactory {
    private static PropertyType propertyType;

    public static AppProperties getAppProperties() {
        switch (propertyType) {
            case DB:
                return ApppropsApplication.getApplicationContext().getBean(DBProperties.class);
            case XML:
                return ApppropsApplication.getApplicationContext().getBean(XMLProperties.class);
            case YML:
                return ApppropsApplication.getApplicationContext().getBean(YAMLProperties.class);
            default:
                throw new IllegalArgumentException("Arges propertyType invalid");
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

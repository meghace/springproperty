package com.appprops.appprops.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.logging.DeferredLog;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

@Component
public class DBProperties implements AppProperties {
    /**
     * Name of the custom property source added by this post processor class
     */
    private static final String PROPERTY_SOURCE_NAME = "databaseProperties";
    private static final DeferredLog log = new DeferredLog();

    private final ConfigurableEnvironment environment;

    public DBProperties(@Autowired ConfigurableEnvironment environment) {
        this.environment = environment;
    }

    @Override
    public void postProcessEnvironment() {

        Map<String, Object> propertySource = new HashMap<>();
        try {

            DataSource ds = DataSourceBuilder
                    .create()
                    .username(environment.getProperty("spring.datasource.username"))
                    .password(environment.getProperty("spring.datasource.password"))
                    .url(environment.getProperty("spring.datasource.jdbc-url"))
                    .driverClassName(environment.getProperty("spring.datasource.driver-class-name"))
                    .build();
            Connection connection = ds.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM public.settings");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                propertySource.put(rs.getString("key"), rs.getString("value"));
            }
            rs.close();
            preparedStatement.clearParameters();
            preparedStatement.close();
            connection.close();
            environment.getPropertySources().addFirst
                    (new MapPropertySource(PROPERTY_SOURCE_NAME, propertySource));

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }


}

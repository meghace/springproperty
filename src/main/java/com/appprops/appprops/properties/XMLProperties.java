package com.appprops.appprops.properties;

import com.appprops.appprops.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Component
public class XMLProperties implements AppProperties {

    private static final String PROPERTY_SOURCE_NAME = "xmlProperties";
    private final ConfigurableEnvironment environment;

    public XMLProperties(@Autowired ConfigurableEnvironment environment) {
        this.environment = environment;
    }

    @Override
    public void postProcessEnvironment() {
        Map<String, Object> propertySource = new HashMap<>();
        InputStream is = getClass().getClassLoader().getResourceAsStream("appsetttings.xml");
        Map<String, Object> data = null;
        try {
            data = MapUtil.parse(is);
            for (Map.Entry<String, Object> entry : data.entrySet()) {

                propertySource.put("note" + "." + entry.getKey(), entry.getValue());

                environment.getPropertySources().addFirst
                        (new MapPropertySource(PROPERTY_SOURCE_NAME, propertySource));
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }


    }

}

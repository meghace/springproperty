package com.appprops.appprops.util;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapUtil {
    public static Map<String, Object> parse(InputStream inputSource) throws SAXException, IOException, ParserConfigurationException {

        final DataCollector handler = new DataCollector();
        SAXParserFactory.newInstance().newSAXParser().parse(inputSource, handler);
        return handler.result;
    }

    public static Map<String, Object> ProcessValues(Map<String, Object> propertySource) {

        Map<String, Object> valueMap = new HashMap<>();
        Map<String, Object> derivedMap = new HashMap<>();

        for (Map.Entry<String, Object> entry : propertySource.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
            if(entry.getValue().toString().contains("${")){
                derivedMap.put(entry.getKey(),entry.getValue());
            }else{
                valueMap.put(entry.getKey(),entry.getValue());
            }
        }
        for (Map.Entry<String, Object> entry : derivedMap.entrySet()) {

            String[] tokens = entry.getValue().toString().split("(?=\\$)");
            for(int i=0;i<tokens.length;i++) {
                int startIndex = tokens[i].indexOf("$");
                int endIndex = tokens[i].indexOf("}");
                String s = tokens[i].substring(startIndex+2,endIndex);
                String value= (String) valueMap.get(s);
                tokens[i]= tokens[i].replace(s,value);
                tokens[i] =tokens[i].replace("$","").replace("{","").replace("}","");

            }
            Arrays.stream(tokens).forEach(System.out::println);
            valueMap.put(entry.getKey(),String.join("",tokens));
            System.out.println(String.join("",tokens));
        }

        return  valueMap;
    }

    private static class DataCollector extends DefaultHandler {
        private final StringBuilder buffer = new StringBuilder();
        private final Map<String, Object> result = new HashMap<String, Object>();

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            final String value = buffer.toString().trim();
            if (value.length() > 0) {
                result.put(qName, value);
            }
            buffer.setLength(0);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            buffer.append(ch, start, length);
        }
    }
}

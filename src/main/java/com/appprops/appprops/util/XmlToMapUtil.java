package com.appprops.appprops.util;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class XmlToMapUtil {
    public static Map<String, Object> parse(InputStream inputSource) throws SAXException, IOException, ParserConfigurationException {

        final DataCollector handler = new DataCollector();
        SAXParserFactory.newInstance().newSAXParser().parse(inputSource, handler);
        return handler.result;
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

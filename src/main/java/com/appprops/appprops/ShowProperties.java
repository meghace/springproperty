package com.appprops.appprops;

import com.appprops.appprops.model.common.SpringNote;
import com.appprops.appprops.model.common.Note;
import com.appprops.appprops.properties.DBProperties;
import com.appprops.appprops.properties.XMLProperties;
import com.appprops.appprops.properties.YAMLProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@Component
@RequestMapping(path = "/common")
public class ShowProperties {


    @Autowired
    Note mynote;
    @Autowired
    SpringNote cassandra;
    @Autowired
    DBProperties dbProperties;
    @Autowired
    XMLProperties xmlProperties;
    @Autowired
    YAMLProperties ymlProperties;

    @GetMapping(path = "/db")
    public void dbProfile() throws ParseException {
        dbProperties.postProcessEnvironment();
    }

    @GetMapping(path = "/yaml")
    public void ymlProfile() throws ParseException {
        ymlProperties.postProcessEnvironment();
    }

    @GetMapping(path = "/xml")
    public void xmlProfile() throws ParseException {
        xmlProperties.postProcessEnvironment();
    }

    @GetMapping(path = "/note")
    public String DisplayNote() {
        return mynote.toString();
    }
    @GetMapping(path = "/cassandra")
    public String DisplayCassandra() {
        return cassandra.toString();
    }
}

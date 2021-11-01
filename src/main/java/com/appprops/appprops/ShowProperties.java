package com.appprops.appprops;

import com.appprops.appprops.properties.DBProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@Component
@RequestMapping(path = "/profile")
public class ShowProperties {



    @Autowired
    Note mynote;
    @Autowired
    DBProperties dbProperties;

    @GetMapping(path ="/db")
    public void dbProfile() throws ParseException {
        dbProperties.postProcessEnvironment();
    }
    @GetMapping(path ="/yaml")
    public void ymlProfile() throws ParseException {
        dbProperties.postProcessEnvironment();
    }
    @GetMapping(path ="xml")
    public void xmlProfile() throws ParseException {
        dbProperties.postProcessEnvironment();
    }

    @GetMapping(path ="/annoted")
    public String Display(){
      return  mynote.toString();
    }


//    @GetMapping(path ="/list")
//    public String DisplayPropertied(){
//
//        Environment environment = ApppropsApplication.getApplicationContext().getEnvironment();
//        Note n = new Note();
//        n.setFrom(environment.getProperty("note.form"));
//        n.setEmail(environment.getProperty("note.to"));
//        n.setSmtp(environment.getProperty("note.smtp"));
//        n.setSubject(environment.getProperty("note.subjet"));
//        return  mynote.toString();
//    }

}

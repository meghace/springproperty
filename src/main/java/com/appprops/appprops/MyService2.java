package com.appprops.appprops;

import com.appprops.appprops.model.microservice2.Note;
import com.appprops.appprops.properties.DBProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
@RequestMapping(path = "/service2")
public class MyService2 {

    @Autowired
    Note mynote;

    @Autowired
    DBProperties dbProperties;

    @GetMapping(path = "/note")
    public String DisplayNote() {
        return mynote.toString();
    }

}

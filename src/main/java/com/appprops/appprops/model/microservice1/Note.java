package com.appprops.appprops.model.microservice1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Component("Note1")
@RefreshScope
public class Note implements Serializable {

    ConfigurableEnvironment environment;
    // @Value("${microservice2.note.from}")
    public String from;
    // @Value("${microservice2.note.email}")
    public String email;
    // @Value("${microservice2.note.subject}")
    public String subject;
    // @Value("${microservice2.note.smtp}")
    public String smtp;
    // @Value("${microservice2.note.smtp.user}")
    public String smtpuser;
    // @Value("${microservice2.note.smtp.login}")
    public String smtplogin;



    public Note(@Autowired ConfigurableEnvironment environment){
        this.environment = environment;
    }

    public String getFrom() {
        return environment.getProperty("microservice1.note.from");
    }

    public String getEmail() {
        return environment.getProperty("microservice1.note.email");
    }

    public String getSubject() {
        return environment.getProperty("microservice1.note.subject");
    }

    public String getSmtp() {
        return environment.getProperty("microservice1.note.smtp");
    }

    public String getSmtpuser() {
        return environment.getProperty("microservice1.note.smtp.user");
    }

    public String getSmtplogin() {
        return environment.getProperty("microservice1.note.smtp.login");
    }

    @Override
    public String toString() {
        return "Note-Service1{" +

                "from='" + getFrom() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", subject='" + getSubject() + '\'' +
                ", smtp='" + getSmtp() + '\'' +
                ", smtpuser='" + getSmtpuser() + '\'' +
                ", smtplogin='" + getSmtplogin() + '\'' +

                '}';
    }

//    @Value("${microservice1.note.from}")
//    public String from;
//    @Value("${microservice1.note.email}")
//    public String email;
//    @Value("${microservice1.note.subject}")
//    public String subject;
//    @Value("${microservice1.note.smtp}")
//    public String smtp;
//    @Value("${microservice1.note.smtp.user}")
//    public String smtpuser;
//    @Value("${microservice1.note.smtp.login}")
//    public String smtplogin;
//
//    ConfigurableEnvironment environment;
//
//    public Note(@Autowired  ConfigurableEnvironment environment){
//            this.environment = environment;
//    }
//
//
//
//
//    @Override
//    public String toString() {
//        return "Note{" +
//                "from='" + from + '\'' +
//                ", email='" + email + '\'' +
//                ", subject='" + subject + '\'' +
//                ", smtp='" + smtp + '\'' +
//                ", smtpuser='" + smtplogin + '\'' +
//
//                '}';
//    }
}

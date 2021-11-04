package com.appprops.appprops;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Component
@RefreshScope
public class Note implements Serializable {

    @Value("${note.from}")
    public String from;
    @Value("${note.email}")
    public String email;
    @Value("${note.subject}")
    public String subject;
    @Value("${note.smtp}")
    public String smtp;

//    public String getFrom() {
//        return from;
//    }
//
//    public void setFrom(String from) {
//        this.from = from;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getSubject() {
//        return subject;
//    }
//
//    public void setSubject(String subject) {
//        this.subject = subject;
//    }
//
//    public String getSmtp() {
//        return smtp;
//    }
//
//    public void setSmtp(String smtp) {
//        this.smtp = smtp;
//    }

    @Override
    public String toString() {
        return "Note{" +
                "from='" + from + '\'' +
                ", email='" + email + '\'' +
                ", subject='" + subject + '\'' +
                ", smtp='" + smtp + '\'' +
                '}';
    }
}

package com.appprops.appprops.model.common;

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
    @Value("${note.smtp.user}")
    public String smtpuser;
    @Value("${note.smtp.login}")
    public String smtplogin;


    @Override
    public String toString() {
        return "Note{" +
                "from='" + from + '\'' +
                ", email='" + email + '\'' +
                ", subject='" + subject + '\'' +
                ", smtp='" + smtp + '\'' +
                ", smtpuser='" + smtpuser + '\'' +
                ", smtplogin='" + smtplogin + '\'' +

                '}';
    }
}

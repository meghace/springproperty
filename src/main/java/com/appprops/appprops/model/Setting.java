package com.appprops.appprops.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Table(name = "db_properties",schema = "public")
@Entity
public class Setting {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "key")
    private String key;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "value")
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

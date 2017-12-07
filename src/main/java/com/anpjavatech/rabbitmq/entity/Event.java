package com.anpjavatech.rabbitmq.entity;

import java.io.Serializable;

public class Event implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

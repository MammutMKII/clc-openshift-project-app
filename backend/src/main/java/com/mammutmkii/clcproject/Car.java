package com.mammutmkii.clcproject;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

//TODO: remove
@RedisHash("Car")
public class Car implements Serializable {
    //private Long id;
    @Id
    private String name;

    //public Long getId() {
    //    return id;
    //}

    //public void setId(Long id) {
    //    this.id = id;
    //}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

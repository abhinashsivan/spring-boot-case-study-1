package com.demo.user.user.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.io.Serializable;

public class Mapper implements Serializable {

    ObjectMapper mapper = new ObjectMapper();

    public Mapper() {
    }

    public String toJsonOb(Object object) {

        String JString;
        try {
            JString = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return "Error Occured";
        }
        return JString;

    }


    public void toJavaOb(JSONPObject job) {

    }

}

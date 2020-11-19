package com.demo.user.user.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Service;

@Service
public class ConvertObj {

    ObjectMapper mapper = new ObjectMapper();

    public ConvertObj() {
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

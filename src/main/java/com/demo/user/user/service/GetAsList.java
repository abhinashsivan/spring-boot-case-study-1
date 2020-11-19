package com.demo.user.user.service;

import com.demo.user.user.domain.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class GetAsList {

    public GetAsList() {
    }

    public List<User> toList(){
        List<User> users = null;

        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream inputStream = new FileInputStream(("src/main/resources/data.json"));
            TypeReference<List<User>> typeReference =  new TypeReference<List<User>>(){} ;
            users = mapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return users;
    }
}

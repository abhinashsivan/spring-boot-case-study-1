package com.demo.user.user.controller;

import com.demo.user.user.domain.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.List;

@RestController
public class View {

    @RequestMapping("/viewall")
    public List<User> viewAll() {
        ObjectMapper mapper = new ObjectMapper();
        List<User> users = null;
        try {
            InputStream inputStream = new FileInputStream(new File("src/main/resources/data.json"));
            TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {
            };
            users = mapper.readValue(inputStream, typeReference);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }
}

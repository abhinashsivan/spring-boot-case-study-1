package com.demo.user.user.controller;

import com.demo.user.user.domain.User;
import com.demo.user.user.service.Mapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class Add {

    @GetMapping("/add")
    public String addOne(@RequestParam(required = true) int id, @RequestParam(required = true) String name, @RequestParam(required = true) String email) throws IOException {

        User new_user = new User(id, name, email);

        Mapper mapper = new Mapper();

        String JsonOB = mapper.toJsonOb(new_user);

        FileInputStream fis = new FileInputStream("src/main/resources/data.json");
        byte[] buffer = new byte[10];
        StringBuilder sb = new StringBuilder();
        while (fis.read(buffer) != -1) {
            sb.append(new String(buffer));
            buffer = new byte[10];
        }
        fis.close();

        String old = sb.toString();

        String nw = JsonOB;

        try {
            JSONArray jsonArray = new JSONArray(old);
            jsonArray.put(new JSONObject(nw));


            FileOutputStream outputStream = new FileOutputStream("src/main/resources/data.json");
            byte[] strtby = jsonArray.toString().getBytes();
            outputStream.write(strtby);
            outputStream.close();
            return nw + " added";
        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println("Exception Happened");
        }
        return "Error";


    }

}
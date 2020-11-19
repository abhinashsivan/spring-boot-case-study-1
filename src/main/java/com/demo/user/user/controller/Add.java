package com.demo.user.user.controller;

import com.demo.user.user.domain.User;
import com.demo.user.user.service.ConvertObj;
import com.demo.user.user.service.DuplicateIdHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class Add {

    @GetMapping("/add")
    public String addOne(@RequestParam(required = true, defaultValue = "-1") int id, @RequestParam(required = true) String name, @RequestParam(required = true) String email) throws IOException {


        if (id == -1 || name.isBlank() || email.isBlank()) {
            return "Kindly check your inputs";
        }

        User new_user = new User(id, name, email);
        DuplicateIdHandler idHandler = new DuplicateIdHandler();

        boolean[] changed = idHandler.checkForDuplicates(new_user);

        if(changed[0]) {
            if (changed[1]) {
                return "Existing element changed";
            } else if (changed[1] == false) {
                return "Error in changing existing item";
            }
        }

        ConvertObj mapper = new ConvertObj();

        String newUserString = mapper.toJsonOb(new_user);

        FileInputStream fis = new FileInputStream("src/main/resources/data.json");
        byte[] buffer = new byte[10];
        StringBuilder sb = new StringBuilder();
        while (fis.read(buffer) != -1) {
            sb.append(new String(buffer));
            buffer = new byte[10];
        }
        fis.close();

        String old = sb.toString();

        try {
            JSONArray jsonArray = new JSONArray(old);
            jsonArray.put(new JSONObject(newUserString));


            FileOutputStream outputStream = new FileOutputStream("src/main/resources/data.json");
            byte[] strtby = jsonArray.toString().getBytes();
            outputStream.write(strtby);
            outputStream.close();
            return "New Item Added";
        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println("Error in adding new item");
        }
        return "Error";


    }

}
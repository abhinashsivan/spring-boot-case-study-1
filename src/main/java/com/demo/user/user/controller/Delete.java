package com.demo.user.user.controller;

import com.demo.user.user.domain.User;
import com.demo.user.user.service.GetAsList;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@RestController
public class Delete {
    public Delete() {
    }

    @GetMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam(defaultValue = "-1", required = false)int id) {

        if(id == -1)
            return "check your input !!";

        List<User> userList ;
        ListIterator<User> litr = null;
        GetAsList tolist = new GetAsList();

        boolean successful = false;

        userList = tolist.toList();

        litr = userList.listIterator();

        while(litr.hasNext()) {
            if (litr.next().getId() == id) {
                litr.remove();
                successful = true;

            }
        }
        try {

            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(userList);

            FileOutputStream outputStream = new FileOutputStream("src/main/resources/data.json");
            byte[] strtby = jsonString.getBytes();
            outputStream.write(strtby);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            successful = false;
            return "excptn";
        } catch (IOException e) {
            e.printStackTrace();
            successful = false;
            return "excptn";
        }


        if (successful) {
            return "User Deleted";
        } else {
            return "Error !";
        }
    }
}

package com.demo.user.user.controller;

import com.demo.user.user.domain.User;
import com.demo.user.user.service.GetAsList;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
public class Delete {
    public Delete() {
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(defaultValue = "-1", required = false)int id) {

        if(id == -1)
            return "def id";

//        List<User> userList;
//        GetAsList tolist = new GetAsList();
//
        boolean successful = true;
//
//        userList = tolist.toList();
//
//        for (User u : userList) {
//            if (u.getId() == id) {
//                userList.remove(u);
//                successful = true;
//
//            }
//        }
//        try {
//
//            ObjectMapper mapper = new ObjectMapper();
//            String jsonString = mapper.writeValueAsString(userList);
//
//            FileOutputStream outputStream = new FileOutputStream("src/main/resources/data.json");
//            byte[] strtby = jsonString.getBytes();
//            outputStream.write(strtby);
//            outputStream.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            successful = false;
//            return "excptn";
//        } catch (IOException e) {
//            e.printStackTrace();
//            successful = false;
//            return "excptn";
//        }
//

        if (successful) {
            return "User Deleted";
        } else {
            return "Error !";
        }
    }
}

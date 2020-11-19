package com.demo.user.user.service;

import com.demo.user.user.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class DuplicateIdHandler {
    public DuplicateIdHandler() {
    }

    public boolean[] checkForDuplicates(User user) {
        boolean changed[] = {false, true};
        GetAsList tolist = new GetAsList();

        List<User> userList;

        userList = tolist.toList();

        for (User u : userList) {
            if (u.getId() == user.getId()) {
                u.setName(user.getName());
                u.setEmail(user.getEmail());
                changed[0] = true;

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
            changed[1] = false;
        } catch (IOException e) {
            e.printStackTrace();
            changed[1] = false;
        }

        return changed;
    }
}

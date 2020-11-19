package com.demo.user.user.controller;

import com.demo.user.user.domain.User;
import com.demo.user.user.service.GetAsList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class View {

    @RequestMapping("/viewall")
    public List<User> viewAll() {
        List<User> users;
        GetAsList Getlist = new GetAsList();

        users = Getlist.toList();

        return users;
    }
}

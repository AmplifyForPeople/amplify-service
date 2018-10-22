package com.amplify.webservice.controller;

import com.amplify.webservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String index() {
        return userService.getUser();
    }

}
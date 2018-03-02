package com.syn.admin.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class UserController {

    @RequestMapping("/")
    public String sayHello() {
        return "Hello User!";
    }

}

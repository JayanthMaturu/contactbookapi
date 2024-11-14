package com.example.contactbookapi.controller;

import com.example.contactbookapi.model.MyUser;
import com.example.contactbookapi.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/signup")
@Controller
public class MyUserController {


    private final MyUserService myUserService;

    public MyUserController(MyUserService myUserService) {
        this.myUserService = myUserService;
    }


    @PostMapping()
    public ResponseEntity<MyUser> createUser(@RequestBody MyUser myUser) {
        return myUserService.createUser(myUser);
    }

}

package com.oocl.web.sampleWebApp.controller;

import com.oocl.web.sampleWebApp.model.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequestMapping("/users")

public class UserController {


    @PostMapping(produces = {"application/json"})
    public ResponseEntity<User> create(@RequestBody User user){
        Integer userId = 0;
        URI location = URI.create("/users/" + userId);
        return ResponseEntity.created(location).build();
    }

}

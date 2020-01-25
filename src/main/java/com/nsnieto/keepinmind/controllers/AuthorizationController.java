package com.nsnieto.keepinmind.controllers;


import com.nsnieto.keepinmind.entities.User;
import com.nsnieto.keepinmind.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
@Controller
public class AuthorizationController {

    @Autowired
    private UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<Object> create(@Validated @RequestBody User user) {

        try {

            return ResponseEntity.ok(userService.create(user));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/list")
    public ResponseEntity<Object> findAll() {

        try {

            return ResponseEntity.ok(userService.findAll());

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


}

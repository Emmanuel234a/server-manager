package com.restapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v5/greetings")
public class Greetings_controller {
    @GetMapping
    public ResponseEntity<String> helloUser(){
        return ResponseEntity.ok("Welcome to spring boot programming");
    }
    @GetMapping("/logout")
    public ResponseEntity<String> logout(){
        return ResponseEntity.ok("Thank you for logging out of the system!");
    }
}

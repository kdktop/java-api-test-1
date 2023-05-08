package com.api.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by @author moya1031 on 2023-05-08
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TestController {

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.status(HttpStatus.OK).body("hello");
    }

    @GetMapping("/hello2")
    public ResponseEntity<String> hello2() {
        return ResponseEntity.status(HttpStatus.OK).body("hello2");
    }
}

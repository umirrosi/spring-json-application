package com.umirrosi.springjsonapplication.controller;

import com.umirrosi.springjsonapplication.model.ResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody ResponseModel request) {
        return ResponseEntity.ok().body(request);
    }

}

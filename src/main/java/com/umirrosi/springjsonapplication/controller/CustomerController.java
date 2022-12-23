package com.umirrosi.springjsonapplication.controller;

import com.umirrosi.springjsonapplication.model.CustomerModel;
import com.umirrosi.springjsonapplication.model.CustomerRequest;
import com.umirrosi.springjsonapplication.model.ResponseModel;
import com.umirrosi.springjsonapplication.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    /*@GetMapping
    public ResponseEntity<Object> get(){
        List<CustomerModel> result = service.getAll();
        return ResponseEntity.ok().body(
                new ResponseModel(result)
        );
    }*/

    /*@PostMapping
    public ResponseEntity<Object> save(@RequestBody CustomerModel request) {
        Optional<CustomerModel> result = service.save(request);
        return ResponseEntity.ok().body(result);
    }*/

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody CustomerRequest request){
        return ResponseEntity.ok().body(
                service.saveAll(request)
        );
    }

}

package com.example.SpringAopdemo.Controller;

import com.example.SpringAopdemo.Service.AopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AopController {

    @Autowired
    public AopService aopservice;

    @GetMapping
    public ResponseEntity<String>getMsg(){
        return ResponseEntity.ok(aopservice.getHelloMsg());
      //return ResponseEntity.ok(aopservice.getHiiMsg());


    }


}

package com.example.Loggingmvc.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    private static Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    @GetMapping("/hello")
    public String getData(@RequestParam String name){
        LOGGER.info("Get request from Hello API:{}"+name);
       return "hello"+name+Thread.currentThread().getName();

    }


}

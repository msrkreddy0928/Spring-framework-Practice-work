package com.example.SpringAopdemo.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.example.SpringAopdemo.Aspect.LogExecutionTime;


@Service

public class AopService {


    private static Logger LOGGER = LoggerFactory.getLogger(AopService.class);


    public String getHelloMsg(){
        LOGGER.info("inside hellomsg");

        return "Hello : "+Thread.currentThread().getName();
    }
   // @LogExecutionTime
    public String getHiiMsg(){
        LOGGER.info("inside hiimsg");

        return "Hii : "+Thread.currentThread().getName();
    }






}

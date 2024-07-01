package com.example.Springbootdemo;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Appcontroller {
    @Autowired
    ProductService productService;

@GetMapping("/hello")
    public String getHello(@RequestParam String name){
        return "Hello "+ name+ "from : "+Thread.currentThread().getName();
    }

    @GetMapping("/product/{id}")
      public Product getproduct(@PathVariable long id){
    return productService.getProductById(id);
    }



    @PostMapping
    public Long createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

}



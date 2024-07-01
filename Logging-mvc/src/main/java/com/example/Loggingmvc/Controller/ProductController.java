package com.example.Loggingmvc.Controller;

import com.example.Loggingmvc.LoggingMvcApplication;
import com.example.Loggingmvc.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping("/getAll")
    public List<LoggingMvcApplication.Productnew>getAllProducts(){
        return productService.getAllData();
    }

    @PostMapping
    public Integer createProduct(@RequestBody LoggingMvcApplication.Productnew product){
    return productService.createProduct(product);
    }



}

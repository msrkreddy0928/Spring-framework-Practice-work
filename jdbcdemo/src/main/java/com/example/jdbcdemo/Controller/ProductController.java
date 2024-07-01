package com.example.jdbcdemo.Controller;


import com.example.jdbcdemo.JdbcdemoApplication;
import com.example.jdbcdemo.Product;
import com.example.jdbcdemo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping("/getAll")
    public List<Product>getAllData(){
        return productService.getAllData();
    }

    @PostMapping("/create")
    public Long createProduct(@RequestBody Product product){
    return productService.createProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product product,@PathVariable Long id){
        return productService.updateProduct(product,id);
    }




}

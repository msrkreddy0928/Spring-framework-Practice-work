package com.example.Reddisdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/product")
public class productController {
    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<Product>createProduct(@RequestBody Product product){
        Long id = productService.createProduct(product);
        URI uri =null;
        try{
            uri = new URI("/product/"+id);
        }
        catch(URISyntaxException e){
            throw new RuntimeException(e);

        }

        return ResponseEntity.created(uri).build();
    }

   @GetMapping("/{id}")
    public ResponseEntity<Product>getByIdLocalCache(@PathVariable Long id){
        Product product = productService.getByIdReddis(id);
        if(product==null){
          return ResponseEntity.notFound().build();
        }
        else{
           return  ResponseEntity.ok(product);
        }

    }


}

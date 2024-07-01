package com.example.RestTemplatedemo;

import com.example.RestTemplatedemo.Client.ProductServiceClient;
import com.example.RestTemplatedemo.Dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/product")
public class ProductProxyController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductServiceClient productServiceClient;

    @Value("${product.service.baseUrl}")
    private String baseUrl;



   /* @GetMapping("/{id}")
    public ResponseEntity<ProductDto>getProduct(@PathVariable Long id){
        String url =baseUrl+"/product/"+id;
        ProductDto productDto = restTemplate.getForObject(url,ProductDto.class);
        return ResponseEntity.ok(productDto);

    }*/
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto>getProduct(@PathVariable Long id){
        ProductDto productDto = productServiceClient.getProduct(id);
        return ResponseEntity.ok(productDto);

    }

   /* @PostMapping("create")
    public ResponseEntity<ProductDto>createProduct(@RequestBody ProductDto productDto){
        String url =baseUrl+"/product";
        ProductDto productDto1 = restTemplate.postForEntity(url,productDto,ProductDto.class).getBody();
        return ResponseEntity.ok(productDto1);

    }*/
    @PostMapping("/create")
    public ResponseEntity<ProductDto>createProduct(@RequestBody ProductDto productDto){
        ProductDto productDto1 = productServiceClient.createProduct(productDto);
        return ResponseEntity.ok(productDto1);

    }
}

package com.example.RestTemplatedemo.Client;

import com.example.RestTemplatedemo.Dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name = "product", url="${product.service.baseUrl}")
@FeignClient(name="PRODUCT-SERVICE")
public interface ProductServiceClient {

    @GetMapping("/product/{id}")
    ProductDto getProduct(@PathVariable Long id);
    @PostMapping("/product")
    ProductDto createProduct(@RequestBody ProductDto productDto);

}


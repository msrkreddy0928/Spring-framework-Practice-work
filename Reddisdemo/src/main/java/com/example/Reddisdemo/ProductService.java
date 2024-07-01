package com.example.Reddisdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class ProductService {

    private Map<Long,Product> localCache = new HashMap<>();
    private Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private RedisTemplate<String,Product>redisTemplate;

    public Long createProduct(Product product){
        product = productRepo.save(product);

        return product.getId();
    }



    public Product getByIdReddis(Long id){

        String key = "product:"+id;
        Product product= redisTemplate.opsForValue().get(key);
        if(product!=null){
            return product;
        }
        else{
            logger.info("cache miss");
            product = productRepo.findById(id).get();
            redisTemplate.opsForValue().set(key,product,5,TimeUnit.MINUTES);
            return redisTemplate.opsForValue().get(key);
        }



    }

    public Product getByIdLocalCache(Long id){

        if(localCache.containsKey(id)){
            logger.info("cache hit");
            return localCache.get(id);
        }
        else{
            logger.info("cache miss");
            Product product= productRepo.findById(id).get();
            localCache.put(id,product);
            return localCache.get(id);
        }



    }
}

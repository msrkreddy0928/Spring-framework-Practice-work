package com.example.Loggingmvc.dao;
import com.example.Loggingmvc.Product;

import com.example.Loggingmvc.LoggingMvcApplication;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

import java.util.*;
@Repository
public class ProductDAO {
    private Map<Integer,LoggingMvcApplication.Productnew> dataStore =new HashMap<>();


    private Integer nextId=0;

    public List<LoggingMvcApplication.Productnew>getAllData(){
        return dataStore.values().stream().toList();
    }

    public Integer createProduct(LoggingMvcApplication.Productnew product){
        nextId++;
        product.setId(nextId);
        dataStore.put(product.getId(),product);
        return product.getId();
    }




}

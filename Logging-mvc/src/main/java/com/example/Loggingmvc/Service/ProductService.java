package com.example.Loggingmvc.Service;

import com.example.Loggingmvc.LoggingMvcApplication;
import com.example.Loggingmvc.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class ProductService {
    @Autowired
     private ProductDAO productDAO;

     public List<LoggingMvcApplication.Productnew>getAllData(){
         return productDAO.getAllData();
     }

     public Integer createProduct(LoggingMvcApplication.Productnew product){
         return productDAO.createProduct(product);
     }




}

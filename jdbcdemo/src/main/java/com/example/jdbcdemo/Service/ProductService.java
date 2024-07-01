package com.example.jdbcdemo.Service;


import com.example.jdbcdemo.Product;
import com.example.jdbcdemo.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

@Service
public class ProductService {
    @Autowired
     private ProductDAO productDAO;

     public List<Product>getAllData(){

         return productDAO.getAllData();
     }

     public Long createProduct(Product product){

         return productDAO.createProduct(product);}

    public Product updateProduct(Product product,Long id){
         return productDAO.updateProduct(product,id);
    }




    public Product getProductById( Long id) {

         return productDAO.getProductById(id);
    }
}

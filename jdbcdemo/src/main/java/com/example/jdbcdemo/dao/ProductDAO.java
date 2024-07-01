package com.example.jdbcdemo.dao;

import com.example.jdbcdemo.Product;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Repository
public class ProductDAO {
    private List<Product> dataStore =new ArrayList<>();


    private Long nextId=0l;

    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String userName;

    @Value("${db.pass}")
    private String pass;

    private static Logger LOGGER = LoggerFactory.getLogger(ProductDAO.class);
    private Connection con=null;
    public List<Product>getAllData(){
        Product product=null;
        try{
            con = DriverManager.getConnection(url,userName,pass);
            String query ="select id,name,cost from product";
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while(result.next()){
                dataStore.add( new Product(result.getLong("id"),result.getString("name"),result.getString("cost")));
            }
            LOGGER.info("created connection");


        }

        catch(SQLException e){
            throw new RuntimeException(e);}
        finally {
            try{
                if(con!=null)
                    con.close();}
            catch(SQLException e){
                throw new RuntimeException(e);
            }}

        return dataStore;
    }

    public Long createProduct(Product product){
        try{
            con = DriverManager.getConnection(url,userName,pass);

            LOGGER.info("created connection");
            String query ="insert into product values('"+product.getId()+"','"+product.getName()+"','"+product.getCost()+"')";
            Statement stmt = con.createStatement();
            int result = stmt.executeUpdate(query,stmt.RETURN_GENERATED_KEYS);

            if(result==0){
                throw new SQLException("creating product failed");
            }

            ResultSet keys = stmt.getGeneratedKeys();

            if(keys.next()){
                product.setId(keys.getLong(1));
            }




        }

        catch(SQLException e){
            throw new RuntimeException(e);


        }

        finally {
            try{
                if(con!=null)
                    con.close();
            }
            catch(SQLException e){
                throw new RuntimeException(e);
            }}


return product.getId();




    }


    public Product updateProduct(Product product,Long id){
        try{
            con = DriverManager.getConnection(url,userName,pass);
            String query ="Update product set name=?,cost=? where id=?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1,product.getName());
            stmt.setString(2,product.getCost());
            stmt.setLong(3,product.getId());
            stmt.executeUpdate();

            LOGGER.info("created connection");


        }

        catch(SQLException e){
            throw new RuntimeException(e);


        }

        finally {
            try{
                if(con!=null)
                    con.close();
            }
            catch(SQLException e){
                throw new RuntimeException(e);}}

        return product;

    }









    public Product getProductById(Long id){
        Product product=null;
        try{
           con = DriverManager.getConnection(url,userName,pass);
            String query ="select id,name,cost from product where id="+id;
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while(result.next()){
                product = new Product(result.getLong("id"),result.getString("name"),result.getString("cost"));
            }
            LOGGER.info("created connection");
            return product;

        }

        catch(SQLException e){
            throw new RuntimeException(e);


        }

        finally {
            try{
            if(con!=null)
                con.close();
        }
            catch(SQLException e){
                throw new RuntimeException(e);
            }}



    } }








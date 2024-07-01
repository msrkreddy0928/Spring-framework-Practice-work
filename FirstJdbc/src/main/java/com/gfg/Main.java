package com.gfg;
import java.sql.*;
public class Main {

    public static void main(String[] args) {
        try{

        String driverName = "com.mysql.cj.jdbc.driver";
        Class.forName(driverName);
        String url="jdbc:mysql://localhost:3306/world";
        String user ="root";
        String pwd ="Reddy0928@#";
        Connection con=DriverManager.getConnection(url,user,pwd);
        Statement st = con.createStatement();
        String query = "Select * from city";
         ResultSet ros =st.executeQuery(query);
         while(ros.next()){
            int id = ros.getInt(1);
            String cname=ros.getString(2);
            String district=ros.getString(3);
            int pop=ros.getInt(4);
            System.out.println(id+" "+cname+" "+district+" "+pop);



         }

         con.close();}

    catch(Exception e){
            e.printStackTrace();

    }
}}
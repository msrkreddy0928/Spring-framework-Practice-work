package com.example.Springbootdemo;

public class Product {
    long id;
    String product;
    int cost;

    public Product(long id,String product,int cost){
        this.id=id;
        this.product=product;
        this.cost=cost;

    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

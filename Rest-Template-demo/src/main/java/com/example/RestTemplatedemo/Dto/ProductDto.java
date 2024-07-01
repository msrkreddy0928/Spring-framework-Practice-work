package com.example.RestTemplatedemo.Dto;

public class ProductDto {

    private Long id;

    private String name;

    private Double cost;

   public ProductDto(Long id,String name,Double cost){
       this.name =name;
       this.cost=cost;
       this.id=id;

   }

   public ProductDto(){

   }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public Double getCost(){
       return cost;
    }
}

package com.example.jakarta.hello;

public class Product {
    private String name;
    private double price;

    public Product(){}
    public Product(String name,double price){
        setName(name);
        setPrice(price);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length()>100){
            throw new RuntimeException("Name cannot be more than 100 char");
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price < 0 ){
            throw new RuntimeException("Price cannot be negative");
        }
        this.price = price;
    }


}

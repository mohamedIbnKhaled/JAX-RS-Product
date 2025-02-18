package com.example.jakarta.hello;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private static ProductManager single_instance;

    private final List<Product> productList = new ArrayList<>();


    private ProductManager(){
    }

    public static ProductManager getInstance(){
        if (single_instance==null){
            single_instance = new ProductManager();
        }
        return single_instance;
    }
    public Product searchProduct(String name){
        return productList.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }


    public  void addProduct(Product product){
        if(searchProduct(product.getName())!=null){
            throw new IllegalStateException("there is a product with the same name");
        }
        productList.add(product);
    }


    public void deleteProduct(Product product){
        productList.remove(product);
    }


    public void updateProduct(String name, String newName , double newPrice){
        Product product =searchProduct(name);
        if(product==null){
            throw new IllegalStateException("there is no product with the same name");
        }else if(searchProduct(newName)!=null) {
            throw new IllegalStateException("there is already product with the new name you want to add");
        }
        product.setName(newName);
        product.setPrice(newPrice);
    }
}

package com.project.ecomm.service;


import com.project.ecomm.model.Product;
import com.project.ecomm.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    ProductRepo repo;

    @Autowired
    ProductService(ProductRepo repo){
        this.repo = repo;
    }


    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProduct(Integer Id){
        return repo.findById(Id).orElse(null);
    }

    public void addProduct(Product product) {
        repo.save(product);
    }
}

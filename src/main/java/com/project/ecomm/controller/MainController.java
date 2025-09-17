package com.project.ecomm.controller;


import com.project.ecomm.model.Product;
import com.project.ecomm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping("/api")
public class MainController {


    ProductService productService;

    @Autowired
    MainController(ProductService productService){
        this.productService = productService;
    }


    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> allProducts = productService.getAllProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    @GetMapping("/getProduct/{Id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer Id){
        Product product = productService.getProduct(Id);
        if(product==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        if(productService.addProduct(product))
            return new ResponseEntity<>(HttpStatus.CREATED);
        return new ResponseEntity<>("Product already exists, use update.",HttpStatus.CONFLICT);
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<?> updateProduct(@RequestBody Product product){
        if(productService.updateProduct(product))
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>("Product does not exist, add Product.",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteProduct/{Id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable Integer Id){
        if(productService.deleteProduct(Id))
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

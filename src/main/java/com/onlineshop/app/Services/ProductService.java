package com.onlineshop.app.Services;

import com.onlineshop.app.Entities.Product;
import com.onlineshop.app.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepo;
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }
    public Optional<Product> getProductById(long id){
        return productRepo.findById(id);
    }

    public List<Product> getProductCartBySessionId(String session_id){
        List<Product> product = productRepo.getProductCartBySession(session_id);
        System.out.println(product);
        if (product != null) {
            return  new ResponseEntity<>(product, HttpStatus.OK).getBody();
        } else {
            return (List<Product>) new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
        }

    }
    public List<Product> getProductByCategoryId(Long category_id){
        List<Product> product = productRepo.getProductByCategoryId(category_id);
        if (product != null) {
            return  new ResponseEntity<>(product, HttpStatus.OK).getBody();
        } else {
            return (List<Product>) new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
        }
    }
}

package com.onlineshop.app.Controllers;
import com.onlineshop.app.Entities.Product;
import com.onlineshop.app.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("api/Product/getAll")
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("api/Product/getProductById/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("api/Product/getProductCartBySessionId/{session_id}")
    public List<Product> getProductCartBySessionId(@PathVariable String session_id) {
        return  productService.getProductCartBySessionId(session_id);
    }

    @GetMapping("api/Product/getProductByCategoryId/{category_id}")
    public List<Product> getProductByCategoryId(@PathVariable Long category_id) {
        return  productService.getProductByCategoryId(category_id);
    }



//    @PostMapping
//    public Product createProduct(@RequestBody Product product) {
//        return productService.createProduct(product);
//    }
//
//    @PutMapping("/{id}")
//    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
//        return productService.updateProduct(id, product);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteProduct(@PathVariable Long id) {
//        productService.deleteProduct(id);
//    }

}

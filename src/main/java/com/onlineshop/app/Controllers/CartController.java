package com.onlineshop.app.Controllers;

import com.onlineshop.app.Entities.Cart_item;
import com.onlineshop.app.Entities.Product;
import com.onlineshop.app.Services.CartService;
import com.onlineshop.app.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;

    @GetMapping("api/cart/getCart")
    public List<Cart_item> getAllProduct() {
        return cartService.getCart();
    }

    @GetMapping("api/cart/getQuantity/{cart_id}")
    public Long getQuantity(@PathVariable Long cart_id) {
        return cartService.getCartQuantity(cart_id);
    }

    @GetMapping("api/cart/getCartBySessionId/{session_id}")
    public List<Map<String, Object>> getCartBySessionId(@PathVariable Long session_id) {
        return cartService.getCartBySessionId(session_id);
    }

    @GetMapping("api/cart/getProductCartByProductId/{product_id}")
    public Product getProductCartByProductId(@PathVariable Long product_id) {
        return cartService.getProductCartByProductId(product_id);
    }

    @GetMapping("api/cart/getTotalPrice/{session_id}")
    public Long getTotalPrice(@PathVariable Long session_id) {
        return cartService.getTotalPrice(session_id);
    }

    @GetMapping("api/cart/addCartItem/{session_id}/{product_id}/{quantity}")
    public String addCartItem(@PathVariable Long session_id, @PathVariable Long product_id, @PathVariable Long quantity) {
        return cartService.addCartItem(session_id, product_id, quantity);
    }

    @GetMapping("api/cart/deleteCartItem/{cart_id}")
    public String deleteCartItem(@PathVariable Long cart_id) {
        return cartService.deleteCartItem(cart_id);
    }

}

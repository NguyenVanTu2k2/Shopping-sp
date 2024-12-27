package com.onlineshop.app.Services;

import com.onlineshop.app.Entities.Cart_item;
import com.onlineshop.app.Entities.Product;
import com.onlineshop.app.Repositories.CartRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepo;

    @Autowired

    public List<Cart_item> getCart() {
        return cartRepo.getAllCart();
    }


    public List<Map<String, Object>> getCartBySessionId(Long session_id) {
        List<Map<String, Object>> cart_item = cartRepo.getAllCartBySession(session_id);
        if (cart_item != null) {

            return new ResponseEntity<>(cart_item, HttpStatus.OK).getBody();
        } else {
            return (List<Map<String, Object>>) new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
        }
    }

    public Product getProductCartByProductId(Long product_id) {
        Product product = cartRepo.getProductCartByProductId(product_id);
        return product;
    }

    public Long getCartQuantity(Long cart_id) {
        return cartRepo.getQuantityByCartId(cart_id);
    }

    public Long getTotalPrice(Long session_id) {
        return cartRepo.getTotalPrice(session_id);
    }

    @Transactional
    public String addCartItem(Long session_id, Long product_id, Long quantity) {

        Cart_item cart_item = cartRepo.getCartBySessionIdAndProductId(session_id, product_id);
        if (cart_item == null) {
            cartRepo.addItemCart(session_id, product_id, quantity);
            return "add item successful";
        } else {
            quantity = cartRepo.getQuantityBySessionidProductId(session_id,product_id);
            cartRepo.updateItemQuantity(session_id, product_id, quantity + 1);
            return "add item successful (update quantity)";
        }
    }

    @Transactional
    public String deleteCartItem(Long cart_id) {
        cartRepo.deleteCartItem(cart_id);
        return "delete item";
    }
}

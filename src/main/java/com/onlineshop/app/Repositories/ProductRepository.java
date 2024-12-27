package com.onlineshop.app.Repositories;
import com.onlineshop.app.Entities.Cart_item;
import com.onlineshop.app.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "SELECT * FROM product WHERE (product_id = ?1)", nativeQuery = true)
    List<Product> getProductById(Long product_id);
    @Query(value = "SELECT product.* FROM product JOIN cart_item ON cart_item.product_id = product.id JOIN shopping_session ON shopping_session.id = cart_item.session_id WHERE (shopping_session.id = ?1)", nativeQuery = true)
    List<Product> getProductCartBySession(String session_id);

    @Query(value = "SELECT * FROM product WHERE (category_id = ?1)", nativeQuery = true)
    List<Product> getProductByCategoryId(Long category_id);
}

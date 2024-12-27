package com.onlineshop.app.Repositories;
import com.onlineshop.app.Entities.Cart_item;
import com.onlineshop.app.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface CartRepository extends JpaRepository<Cart_item,Long> {
    @Modifying
    @Query(value = "INSERT INTO cart_item (session_id, product_id, quantity) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void addItemCart(Long session_id, Long product_id, Long quantity);
    @Modifying
    @Query(value = "UPDATE cart_item SET quantity = ?3 WHERE session_id = ?1 AND product_id = ?2", nativeQuery = true)
    void updateItemQuantity( Long session_id, Long product_id, Long quantity);
    @Query(value = "SELECT * FROM cart_item", nativeQuery = true)
    List<Cart_item> getAllCart();
    @Query(value = "SELECT quantity FROM cart_item Where id = ?1", nativeQuery = true)
    Long getQuantityByCartId(Long cart_id);

    @Query(value = "SELECT quantity FROM cart_item Where session_id = ?1 and product_id = ?2", nativeQuery = true)
    Long getQuantityBySessionidProductId(Long session_id, Long product_id);
    @Query(value = "SELECT * FROM cart_item Where session_id  = ?1 and  product_id = ?2", nativeQuery = true)
    Cart_item getCartBySessionIdAndProductId(Long session_id, Long product_id);

    @Query(value = "SELECT cart_item.id , cart_item.product_id,product.name, product.price, cart_item.quantity , cart_item.created_at ,cart_item.modified_at, cart_item.session_id, product.icon FROM cart_item JOIN product on cart_item.product_id = product.id  WHERE cart_item.session_id = ?1", nativeQuery = true)
    List<Map<String, Object>> getAllCartBySession(Long session_id);
    @Query(value = "SELECT * FROM product WHERE (id = ?1)", nativeQuery = true)
    Product getProductCartByProductId(Long product);
    @Query(value = "SELECT SUM(product.price  * cart_item.quantity) AS total_price FROM cart_item  JOIN product ON cart_item.product_id  = product.id  WHERE cart_item.session_id = ?1", nativeQuery = true)
    Long getTotalPrice(Long session_id);
    @Modifying
    @Query(value = "DELETE FROM cart_item WHERE id = ?1 ", nativeQuery = true)
    void deleteCartItem(Long session_id);
}

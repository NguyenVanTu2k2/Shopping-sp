package com.onlineshop.app.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cart_item")
public class Cart_item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long session_id;
    Long product_id;
    Long quantity;

    public Long getSession_id() {
        return session_id;
    }

    public void setSession_id(Long session_id) {
        this.session_id = session_id;
    }

    String created_at;
    String modified_at;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getModified_at() {
        return modified_at;
    }

    public void setModified_at(String modified_at) {
        this.modified_at = modified_at;
    }

}

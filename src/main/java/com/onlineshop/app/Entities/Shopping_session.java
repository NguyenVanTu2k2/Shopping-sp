package com.onlineshop.app.Entities;
import jakarta.persistence.*;
@Entity
@Table(name = "shopping_session")
public class Shopping_session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String user_id;
    String total;
    String created_at;
    String modified_at;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
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

package com.onlineshop.app.Repositories;
import com.onlineshop.app.Entities.Shopping_session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SessionRepository extends JpaRepository<Shopping_session,Long> {
    @Query(value = "SELECT * FROM shopping_session WHERE id = ?1", nativeQuery = true)
    Shopping_session getSessionId(String id);
}

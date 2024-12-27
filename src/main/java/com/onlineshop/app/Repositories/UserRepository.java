package com.onlineshop.app.Repositories;
import com.onlineshop.app.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM user WHERE username = ?1 and password = ?2", nativeQuery = true)
    User signIn(String username,String password);

    @Query(value = "SELECT id FROM user WHERE username = ?1 and password = ?2", nativeQuery = true)
    String getUserId(String username,String password);
}

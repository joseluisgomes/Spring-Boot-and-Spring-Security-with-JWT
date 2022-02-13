package com.example.userservice.Repo;

import com.example.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    @Query("SELECT s FROM User s WHERE s.username = ?1")
    Optional<User> findUserByUsername(String username);
}

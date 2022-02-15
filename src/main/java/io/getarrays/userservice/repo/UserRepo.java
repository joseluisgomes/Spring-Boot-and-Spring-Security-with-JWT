package io.getarrays.userservice.repo;

import io.getarrays.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User findByUsername(String username);
}

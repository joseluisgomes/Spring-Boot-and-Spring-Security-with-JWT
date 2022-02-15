package io.getarrays.userservice.repo;

import io.getarrays.userservice.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepo extends JpaRepository<Role, Long> {

    @Query("SELECT r FROM Role r WHERE r.name = ?1")
    Role findByName(String name);
}

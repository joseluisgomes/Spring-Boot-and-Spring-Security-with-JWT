package io.getarrays.userservice.service;

import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User>getUsers();
}

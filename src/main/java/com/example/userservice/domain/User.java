package com.example.userservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    private String username;
    private String password;
    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof User user))
            return false;
        return name.equals(user.name) &&
                username.equals(user.username) &&
                password.equals(user.password);
    }

    /*
       31 equals to a shift and subtraction, for better performance
       on some architectures: 31 * i = (i << 5) - i
    */
    @Override
    public int hashCode() {
       int result = name.hashCode();
       result = 31 * result + username.hashCode();
       result = 31 * result + password.hashCode();
       return result;
    }
}

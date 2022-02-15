package io.getarrays.userservice.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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
        if (!(o instanceof User))
            return false;
        User user = (User) o;
        return user.username.equals(username) && user.password.equals(password);
    }

    /*
        31 equals to a shift and subtraction, for better performance
        on some architectures: 31 * i = (i << 5) - i
    */
    @Override
    public int hashCode() {
        return 31 * password.hashCode() + username.hashCode();
    }
}

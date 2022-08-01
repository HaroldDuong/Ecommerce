package com.mock.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

/**
 * author: CuongTTC
 */

@Entity
@Table(name = "users")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String role;
    private boolean enabled;

    public User(String username, String password, String email, String role, boolean enabled) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.enabled = enabled;
    }

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(
                username,
                passwordEncoder.encode(password),
                email,
                "ROLE_USER",
                true

        );
    }
}

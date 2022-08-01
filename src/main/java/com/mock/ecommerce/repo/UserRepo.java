package com.mock.ecommerce.repo;

import com.mock.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * author: CuongTTC
 * */
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUserName(String username);
    int countByUsername(String username);
    int countByEmail(String Email);
    User findByUsernameAndEmail(String username, String email);
    User findByEmail(String email);

}

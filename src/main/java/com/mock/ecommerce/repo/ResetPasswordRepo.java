package com.mock.ecommerce.repo;

import com.mock.ecommerce.entity.ResetPassword;
import com.mock.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * author: CuongTTC
 * */
@Repository
public interface ResetPasswordRepo extends JpaRepository<ResetPassword, Long> {
    ResetPassword findByUser(User user);
    ResetPassword findByResetToken(String resetToken);

}

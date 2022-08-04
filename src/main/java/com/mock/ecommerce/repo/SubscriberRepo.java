package com.mock.ecommerce.repo;

import com.mock.ecommerce.entity.EmailSubscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
* author: CuongTTC
* */
@Repository
public interface SubscriberRepo extends JpaRepository<EmailSubscriber, Long> {
    Optional<EmailSubscriber> findById(Long id);
    List<EmailSubscriber> findAll();
    Long countByEmail(String email);

}

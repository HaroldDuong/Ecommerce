package com.mock.ecommerce.repo;

import com.mock.ecommerce.entity.EmailSubcriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
* author: CuongTTC
* */
@Repository
public interface SubcriberRepo extends JpaRepository<EmailSubcriber, Long> {
    Optional<EmailSubcriber> findById(Long id);
    List<EmailSubcriber> findAll();
    Long countByEmail(String email);

}

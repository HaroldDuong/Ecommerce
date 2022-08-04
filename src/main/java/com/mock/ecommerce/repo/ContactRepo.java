package com.mock.ecommerce.repo;

import com.mock.ecommerce.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * author: CuongTTC
 * */

@Repository
public interface ContactRepo extends JpaRepository<Contact, Long> {

    List<Contact> findByNameContaining(String a);
}

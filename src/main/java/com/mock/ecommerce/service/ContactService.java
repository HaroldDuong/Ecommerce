package com.mock.ecommerce.service;

import com.mock.ecommerce.entity.Contact;
import com.mock.ecommerce.repo.ContactRepo;
import com.mock.ecommerce.repo.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author CuongTTC
 *
 */
@Service
@Transactional
public class ContactService implements DAO<Contact>{

	private final ContactRepo contactRepo;

	@Autowired
	public ContactService(ContactRepo contactRepo) {
		this.contactRepo = contactRepo;
	}

	@Override
    public void save(Contact vo) {
		contactRepo.save(vo);
    }

	@Override
	public List<Contact> findALl() {
		return contactRepo.findAll();
	}

	@Override
	public Contact findById(Long id) {
		return contactRepo.findById(id).get();
	}
	@Override
	public void delete(Long id) {
		contactRepo.deleteById(id);
		
	}
}
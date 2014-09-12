package com.exapmle.tjago.service;

import com.exapmle.tjago.dao.ContactRepository;
import com.exapmle.tjago.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by snallangi on 9/9/14.
 */
@Service
public class PhoneBookService {

    @Autowired
    private ContactRepository contactRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Contact> getAll(){
        return contactRepository.findAll();
    }


    public void save(Contact contact) {
        contactRepository.save(contact);
    }

    public Contact find(Long id) {
        return contactRepository.findOne(id);
    }

    public void delete(Long id) {
        contactRepository.delete(id);
    }
}

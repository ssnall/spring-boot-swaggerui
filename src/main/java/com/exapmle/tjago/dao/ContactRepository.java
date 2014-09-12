package com.exapmle.tjago.dao;

import com.exapmle.tjago.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by snallangi on 9/9/14.
 */
public interface ContactRepository extends JpaRepository<Contact,Long>{
}

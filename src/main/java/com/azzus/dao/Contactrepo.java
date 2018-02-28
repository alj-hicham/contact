package com.azzus.dao;

import com.azzus.domain.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface Contactrepo extends JpaRepository<Contact, Long> {
    @Query("select c from Contact c where c.nom like :x")
    Page<Contact> searching(@Param("x") String mc, Pageable pageable);

}

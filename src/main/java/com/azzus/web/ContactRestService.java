package com.azzus.web;

import com.azzus.dao.Contactrepo;
import com.azzus.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactRestService {

    @Autowired
    private Contactrepo contactrepository;

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public List<Contact> getContact() {
        return contactrepository.findAll();
    }

    @RequestMapping(value = "/contact/{id}", method = RequestMethod.GET)
    public Contact getContact(@PathVariable Long id) {

        return contactrepository.findOne(id);

    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public Contact save(@RequestBody Contact contact) {

        return contactrepository.save(contact);

    }

    @RequestMapping(value = "/contact/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable Long id) {
        contactrepository.delete(id);
        return true;
    }

    @RequestMapping(value = "/contact/{id}", method = RequestMethod.PUT)
    public Contact save(@PathVariable Long id, @RequestBody Contact contact) {
        contact.setId(id);
        return contactrepository.save(contact);

    }

    @RequestMapping(value = "/searchcontact", method = RequestMethod.GET)
    public Page<Contact> searching(@RequestParam(name = "mc", defaultValue = "") String mc,
                                   @RequestParam(name = "page", defaultValue = "0") int page,
                                   @RequestParam(name = "size", defaultValue = "5") int size) {
        return contactrepository.searching("%" + mc + "%", new PageRequest(page, size));
    }
}

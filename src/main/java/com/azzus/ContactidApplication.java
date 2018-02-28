package com.azzus;

import com.azzus.dao.Contactrepo;
import com.azzus.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@SpringBootApplication
public class ContactidApplication implements CommandLineRunner {
    @Autowired
    private Contactrepo contactrepository;


    public static void main(String[] args) {
        SpringApplication.run(ContactidApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        contactrepository.save(new Contact("hicham", "alj", df.parse("22/10/1993"), "aljhicham@gmail.com", 576278254, "hicham"));
        contactrepository.save(new Contact("petra",
                "gorlinge",
                df.parse("22/10/1993"),
                "aljhicham@gmail.com",
                576278254,
                "hicham"));
        contactrepository.findAll().forEach(c -> {
            System.out.println(c.getNom());
        });

    }
}

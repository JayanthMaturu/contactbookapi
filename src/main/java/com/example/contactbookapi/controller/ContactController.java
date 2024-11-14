package com.example.contactbookapi.controller;

import com.example.contactbookapi.model.Contact;
import com.example.contactbookapi.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public ResponseEntity<List<Contact>> allContacts(){
        return contactService.allContacts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable int id){
        return contactService.getContactById(id);
    }

    @PostMapping()
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact){
        return contactService.createContact(contact);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable int id){
        return contactService.deleteContact(id);
    }
}

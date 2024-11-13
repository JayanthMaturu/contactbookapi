package com.example.contactbookapi.service;

import com.example.contactbookapi.DAO.ContactRepository;
import com.example.contactbookapi.models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public ResponseEntity<List<Contact>> allContacts() {
        List<Contact> contacts = contactRepository.findAll();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    public ResponseEntity<Contact> getContactById(int id) {
        if(contactRepository.existsById(id)) {
            return new ResponseEntity<>(contactRepository.findById(id).get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<Contact> createContact(Contact contact) {
        return new ResponseEntity<>(contactRepository.save(contact),HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteContact(int id) {
        if (contactRepository.existsById(id)) {
            contactRepository.deleteById(id);
            return new ResponseEntity<>("Contact deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Contact not found", HttpStatus.NOT_FOUND);
        }
    }
}

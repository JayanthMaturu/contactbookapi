package com.example.contactbookapi.service;

import com.example.contactbookapi.DAO.MyUserRepository;
import com.example.contactbookapi.model.MyUser;
import com.example.contactbookapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserService implements UserDetailsService {

    private final MyUserRepository myUserRepository;

    public MyUserService(MyUserRepository myUserRepository) {
        this.myUserRepository = myUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = myUserRepository.findByUsername(username);
        if(myUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(myUser);
    }

    public ResponseEntity<MyUser> createUser(MyUser myUser) {
        myUserRepository.save(myUser);
        System.out.println("MyUserService");
        return new ResponseEntity<>(myUser, HttpStatus.CREATED);
    }
}

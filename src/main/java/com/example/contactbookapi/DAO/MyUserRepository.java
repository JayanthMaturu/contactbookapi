package com.example.contactbookapi.DAO;

import com.example.contactbookapi.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, String> {
    MyUser findByUsername(String username);
}

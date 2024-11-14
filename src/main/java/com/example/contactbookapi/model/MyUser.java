package com.example.contactbookapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MyUser {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    private String id;
    private String username;
    private String password;
}

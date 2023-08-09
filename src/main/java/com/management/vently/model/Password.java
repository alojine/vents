package com.management.vently.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class Password {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 100)
    private String applicationName;

    @Column
    private String emailAddress;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Timestamp createdAt;

    @Column(nullable = false)
    private Timestamp updatedAt;


}

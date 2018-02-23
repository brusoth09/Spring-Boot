package com.dsa.persistence.multiple.model.user;

import javax.persistence.*;

@Entity
@Table(schema = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private int age;
}

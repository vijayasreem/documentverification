package com.DocumentVerification.model;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    // Add more attributes as needed

    // Add getters and setters

    // Add constructors

    // Add toString method

    // Add any additional methods as needed

}
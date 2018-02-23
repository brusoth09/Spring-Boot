package com.dsa.persistence.multiple.model.product;

import javax.persistence.*;

@Entity
@Table(schema = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private double price;
}

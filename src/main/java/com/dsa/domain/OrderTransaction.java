package com.dsa.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "order")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String Name;
    private double price;
}

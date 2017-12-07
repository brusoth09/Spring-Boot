package com.dsa.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {

    private static enum Gender {
        MALE,
        FEMALE;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min = 1, max = 64, message = "First name length should be less than 64 and greater than 1")
    private String firstName;
    @Size(min = 1, max = 64, message = "Last name length should be less than 64 and greater than 1")
    private String lastName;
    @Pattern(regexp = "(^[1-9]{1}[0-9]{9}$)|(^$)", message = "Phone number format is invalid")
    @OneToOne(cascade = CascadeType.ALL)
    private String phoneNumber;
    private Gender gender;
    private Address address;


}

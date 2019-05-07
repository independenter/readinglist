package com.asiainfo.readinglist.entiy;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
@Data
public class Address {

    private String firstName;
    @Id
    private String lastName;
    private String state;
    private String city;
    @Column(name = "postcode")
    private String postCode;
    @Column(name = "address")
    private String addressLine1;
}

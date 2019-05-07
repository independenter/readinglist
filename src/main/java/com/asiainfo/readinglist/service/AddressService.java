package com.asiainfo.readinglist.service;

import com.asiainfo.readinglist.entiy.Address;

import java.util.List;

public interface AddressService {
    public Address findByLastName(String lastName);
    public List<Address> findAddressByFirstName(String firstName);
}

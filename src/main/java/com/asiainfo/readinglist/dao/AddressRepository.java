package com.asiainfo.readinglist.dao;

import com.asiainfo.readinglist.entiy.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {
    public Address findByLastName(String lastName);
    List<Address> findAddressByFirstName(String firstName);
}

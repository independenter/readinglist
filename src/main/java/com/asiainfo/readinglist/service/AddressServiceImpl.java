package com.asiainfo.readinglist.service;

import com.asiainfo.readinglist.dao.AddressRepository;
import com.asiainfo.readinglist.entiy.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "addressService")
public class AddressServiceImpl implements AddressService {

    @Autowired
    public AddressRepository addressRepository;

    @Override
    public Address findByLastName(String lastName) {
        return addressRepository.findByLastName(lastName);
    }
    public List<Address> findAddressByFirstName(String firstName){
        return addressRepository.findAddressByFirstName("P");
    }


}

package com.asiainfo.readinglist;

import com.asiainfo.readinglist.entiy.Address;
import com.asiainfo.readinglist.service.AddressService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test1 {
    @Autowired
    private AddressService addressService;

    @Test
    @SuppressWarnings(value = "rawtypes")
    public void testService() {
        Address address = addressService.findByLastName("Sheman");
        assertEquals("P", address.getFirstName());
        assertEquals("Sheman", address.getLastName());
        assertEquals("42 Wallaby Way", address.getAddressLine1());
        assertEquals("Sydney", address.getCity());
        assertEquals("New South Wales", address.getState());
        assertEquals("2000", address.getPostCode());
        List<Address> addressList = addressService.findAddressByFirstName("P");
        System.out.println(addressList);
    }


}

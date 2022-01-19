package com.revature.repos;

import com.revature.models.Address;

import java.util.List;

public interface AddressDAO {

    List<Address> findAllAddress();
    Address findAddressById(int id);
    boolean updateAddress(Address address);
    boolean addAddress(Address address);
    boolean deleteAddress(int id);

}

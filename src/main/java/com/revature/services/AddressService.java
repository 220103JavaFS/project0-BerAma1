package com.revature.services;

import com.revature.models.Address;

import com.revature.repos.AddressDAO;
import com.revature.repos.AddressDAOImpl;

import java.util.List;

public class AddressService {

    private AddressDAO addressDAO = new AddressDAOImpl();

    public List<Address> findAllAddress(){
        return addressDAO.findAllAddress(); }

    public Address findAddressById(int id){
        return addressDAO.findAddressById(id);
    }

    public boolean updateAddress(Address address){
        return addressDAO.updateAddress(address);
    }

    public boolean addAddress(Address address){
        return addressDAO.addAddress(address);
    }
    public boolean deleteAddress(int address){
        return addressDAO.deleteAddress(address);
    }
}

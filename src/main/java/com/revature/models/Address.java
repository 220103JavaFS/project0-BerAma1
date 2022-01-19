package com.revature.models;

import java.util.Objects;

public class Address {
    private int address_Id;
    private String street_Address;
    private String  city;
    private String state;
    private String zip_Code;

    public Address() {
    }

    public Address(int address_Id, String street_Address, String city, String state, String zip_Code) {
        this.address_Id = address_Id;
        this.street_Address = street_Address;
        this.city = city;
        this.state = state;
        this.zip_Code = zip_Code;
    }

    public int getAddress_Id() {
        return address_Id;
    }

    public void setAddress_Id(int address_Id) {
        this.address_Id = address_Id;
    }

    public String getStreet_Address() {
        return street_Address;
    }

    public void setStreet_Address(String street_Address) {
        this.street_Address = street_Address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip_Code() {
        return zip_Code;
    }

    public void setZip_Code(String zip_Code) {
        this.zip_Code = zip_Code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return address_Id == address.address_Id && Objects.equals(street_Address, address.street_Address) && Objects.equals(city, address.city) && Objects.equals(state, address.state) && Objects.equals(zip_Code, address.zip_Code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address_Id, street_Address, city, state, zip_Code);
    }

    @Override
    public String toString() {
        return "Address{" +
                "address_Id=" + address_Id +
                ", street_Address='" + street_Address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip_Code='" + zip_Code + '\'' +
                '}';
    }
}

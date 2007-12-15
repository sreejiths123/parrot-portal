package com.parrot.eshop.domain.impl;

import com.parrot.eshop.domain.IAddress;


/**
 * @author macekpet
 */
public class Address implements IAddress {
    
    private String city;
    private String email;
    private int id;
    private String name;
    private String region;
    private String street;
    private String telephone;
    private String zip;
    
     /** {@inheritDoc} */
    public String getCity() {
        return city;
    }
    
     /** {@inheritDoc} */
    public String getEmail() {
        return email;
    }
    
     /** {@inheritDoc} */
    public int getId() {
        return id;
    }
    
     /** {@inheritDoc} */
    public String getName() {
        return name;
    }
    
     /** {@inheritDoc} */
    public String getRegion() {
        return region;
    }
    
     /** {@inheritDoc} */
    public String getStreet() {
        return street;
    }
    
     /** {@inheritDoc} */
    public String getTelephone() {
        return telephone;
    }
    
     /** {@inheritDoc} */
    public String getZip() {
        return zip;
    }
    
     /** {@inheritDoc} */
    public void setCity(String city) {
        this.city = city;
    }
    
     /** {@inheritDoc} */
    public void setEmail(String email) {
        this.email = email;
    }
    
     /** {@inheritDoc} */
    public void setId(int id) {
        this.id = id;
    }
    
     /** {@inheritDoc} */
    public void setName(String name) {
        this.name = name;
    }
    
     /** {@inheritDoc} */
    public void setRegion(String region) {
        this.region = region;
    }
    
     /** {@inheritDoc} */
    public void setStreet(String street) {
        this.street = street;
    }
    
     /** {@inheritDoc} */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
     /** {@inheritDoc} */
    public void setZip(String zip) {
        this.zip = zip;
    }
    

}

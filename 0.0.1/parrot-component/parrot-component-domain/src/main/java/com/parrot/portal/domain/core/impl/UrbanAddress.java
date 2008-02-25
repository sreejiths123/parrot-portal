/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.portal.domain.core.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.parrot.portal.domain.core.ICountry;
import com.parrot.portal.domain.core.IUrbanAddress;


/**
 * @author tajzivit
 */
public class UrbanAddress implements IUrbanAddress {
    
    private static final long serialVersionUID = -2681161888816869477L;
    
    private String areaCode;
    private String city;
    @Autowired
    private ICountry country;
    private int doorNumber;
    private int floorNumber;
    private String region;
    private String streetName;
    private int streetNumber;
    
    
    /** {@inheritDoc} */
    public String getAreaCode() {
        return areaCode;
    }
    
    /** {@inheritDoc} */
    public String getCity() {
        return city;
    }
    
    /** {@inheritDoc} */
    public ICountry getCountry() {
        return country;
    }
    
    /** {@inheritDoc} */
    public int getDoorNumber() {
        return doorNumber;
    }
    
    /** {@inheritDoc} */
    public int getFloorNumber() {
        return floorNumber;
    }
    
    /** {@inheritDoc} */
    public String getRegion() {
        return region;
    }
    
    /** {@inheritDoc} */
    public String getStreetName() {
        return streetName;
    }
    
    /** {@inheritDoc} */
    public int getStreetNumber() {
        return streetNumber;
    }
    
    /** {@inheritDoc} */
    public void setAreaCode(String code) {
        this.areaCode = code;
    }
    
    /** {@inheritDoc} */
    public void setCity(String city) {
        this.city = city;
    }
    
    /** {@inheritDoc} */
    public void setCountry(ICountry country) {
        this.country = country;
    }
    
    /** {@inheritDoc} */
    public void setFloorNumber(int number) {
        this.floorNumber = number;
    }
    
    /** {@inheritDoc} */
    public void setRegion(String region) {
        this.region = region;
    }
    
    /** {@inheritDoc} */
    public void setStreetName(String name) {
        this.streetName = name;
    }
    
    /** {@inheritDoc} */
    public void setStreetNumber(int number) {
        this.streetNumber = number;
    }
}

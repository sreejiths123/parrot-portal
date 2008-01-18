/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.portal.domain.core.impl;

import org.springframework.beans.factory.annotation.Configurable;

import com.parrot.portal.domain.core.ICountry;
import com.parrot.portal.domain.core.IUrbanAddress;


/**
 * @author tajzivit
 */
@Configurable("domain-urbanAddress")
public class UrbanAddress implements IUrbanAddress {
    
    private ICountry country;
    private int doorNumber;
    private int floorNumber;
    private String streetName;
    private int streetNumber;
    
    
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
    public String getStreetName() {
        return streetName;
    }
    
    /** {@inheritDoc} */
    public int getStreetNumber() {
        return streetNumber;
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
    public void setStreetName(String name) {
        this.streetName = name;
    }
    
    /** {@inheritDoc} */
    public void setStreetNumber(int number) {
        this.streetNumber = number;
    }
}

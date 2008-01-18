/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.portal.domain.core;


/**
 * @author tajzivit
 */
public interface IUrbanAddress extends IAddress {
    
    /**
     * @return country of user
     */
    ICountry getCountry();
    
    /**
     * @return door number
     */
    int getDoorNumber();
    
    /**
     * @return floor in the building
     */
    int getFloorNumber();
    
    /**
     * @return name of street
     */
    String getStreetName();
    
    /**
     * @return street number
     */
    int getStreetNumber();
    
    /**
     * @param country
     */
    void setCountry(ICountry country);
    
    /**
     * @param number
     */
    void setFloorNumber(int number);
    
    /**
     * @param name
     */
    void setStreetName(String name);
    
    /**
     * @param number
     */
    void setStreetNumber(int number);
}

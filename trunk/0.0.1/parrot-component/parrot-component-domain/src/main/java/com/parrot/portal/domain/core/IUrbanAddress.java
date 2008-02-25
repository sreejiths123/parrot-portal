/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.portal.domain.core;


/**
 * @author tajzivit
 */
public interface IUrbanAddress extends IAddress {
    
    /**
     * @return
     */
    String getAreaCode();
    
    /**
     * @return city
     */
    String getCity();
    
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
     * @return
     */
    String getRegion();
    
    /**
     * @return name of street
     */
    String getStreetName();
    
    /**
     * @return street number
     */
    int getStreetNumber();
    
    /**
     * @param code
     */
    void setAreaCode(String code);
    
    /**
     * @param city
     */
    void setCity(String city);
    
    /**
     * @param country
     */
    void setCountry(ICountry country);
    
    
    /**
     * @param number
     */
    void setDoorNumber(int number);
    
    /**
     * @param number
     */
    void setFloorNumber(int number);
    
    /**
     * @param region
     */
    void setRegion(String region);
    
    /**
     * @param name
     */
    void setStreetName(String name);
    
    /**
     * @param number
     */
    void setStreetNumber(int number);
}

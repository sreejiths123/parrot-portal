/*******************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 ******************************************************************************/

package com.parrot.eshop.domain;



/**
 * @author macekpet
 *
 */
public interface IAddress {
    
    /**
     * @return the city
     */
    String getCity();
    
    /**
     * @return the email
     */
    String getEmail();
    
    /**
     * @return the id
     */
    int getId();
    
    /**
     * @return the name
     */
    String getName();
    
    /**
     * @return the region
     */
    String getRegion();
    
    /**
     * @return the street
     */
    String getStreet();
    
    /**
     * @return the telephone
     */
    String getTelephone();
    
    /**
     * @return the zip
     */
    String getZip();
    
    /**
     * @param city
     *                the city to set
     */
    void setCity(String city);
    
    /**
     * @param email
     *                the email to set
     */
    void setEmail(String email);
    
    /**
     * @param id
     *                the id to set
     */
    void setId(int id);
    
    /**
     * @param name
     *                the name to set
     */
    void setName(String name);
    
    /**
     * @param region
     *                the region to set
     */
    void setRegion(String region);
    
    /**
     * @param street
     *                the street to set
     */
    void setStreet(String street);
    
    /**
     * @param telephone
     *                the telephone to set
     */
    void setTelephone(String telephone);
    
    /**
     * @param zip
     *                the zip to set
     */
    void setZip(String zip);
    
}

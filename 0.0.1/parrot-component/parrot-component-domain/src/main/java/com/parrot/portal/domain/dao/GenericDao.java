package com.parrot.portal.domain.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Generic DAO interface providing base CRUD operations.
 * 
 * @author macekpet
 * @param <T>
 * @param <PK>
 */
public interface GenericDao<T, PK extends Serializable> {
    
    /** Persist the newInstance object into database */
    PK create(T newInstance);
    
    /** Remove an object from persistent storage in the database */
    void delete(T persistentObject);
    
    /**
     * @return list of the objects
     */
    List<T> list();
    
    /**
     * Retrieve an object that was previously persisted to the database using the indicated id as
     * primary key
     */
    T read(PK id);
    
    /** Save changes made to a persistent object. */
    void update(T transientObject);
}

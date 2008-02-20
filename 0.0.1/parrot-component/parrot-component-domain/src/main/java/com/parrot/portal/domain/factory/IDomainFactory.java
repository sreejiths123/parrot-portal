package com.parrot.portal.domain.factory;


/**
 * @author tajzivit This is interface for all factories supose to return filled up domain object
 *         which are going to be used in controllers.
 */
public interface IDomainFactory {
    
    
    /**
     * @param <T>
     *                type of requested object
     * @param objetcsClass
     *                requested object class
     * @return filled up domain object according to given class
     */
    <T> T getDomainObject(Class<T> objetcsClass);
}

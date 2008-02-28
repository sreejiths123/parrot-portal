package com.parrot.portal.controller.command;


/**
 * @author tajzivit
 */
public interface IParrotCommand<T> {
    
    /**
     * @return
     */
    int getId();
    
    /**
     * @return current command
     */
    T getObject();
    
    /**
     * @return objects id
     */
    Integer getObjectsId();
    
    /**
     * @return type of the command
     */
    CommandType getType();
    
    /**
     * @param id
     */
    void setId(int id);
    
    /**
     * @param command
     *                current command to be set
     */
    void setObject(T command);
    
    /**
     * 
     */
    void setObjectsId(Integer id);
    
    /**
     * @param type
     *                of the command
     */
    void setType(CommandType type);
}

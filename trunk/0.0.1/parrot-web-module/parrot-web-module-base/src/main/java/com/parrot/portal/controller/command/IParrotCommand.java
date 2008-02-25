package com.parrot.portal.controller.command;


/**
 * @author tajzivit
 */
public interface IParrotCommand<T> {
    
    /**
     * @return current command
     */
    T getCommand();
    
    int getId();
    
    /**
     * @return type of the command
     */
    CommandType getType();
    
    /**
     * @param command
     *                current command to be set
     */
    void setCommand(T command);
    
    void setId(int id);
    
    /**
     * @param type
     *                of the command
     */
    void setType(CommandType type);
}

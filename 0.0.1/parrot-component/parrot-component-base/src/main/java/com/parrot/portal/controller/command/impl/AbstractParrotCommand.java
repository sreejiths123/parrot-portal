package com.parrot.portal.controller.command.impl;

import com.parrot.portal.controller.command.CommandType;
import com.parrot.portal.controller.command.IParrotCommand;


/**
 * @author tajzivit
 */
public abstract class AbstractParrotCommand<T> implements IParrotCommand<T> {
    
    private T command;
    private int id;
    private CommandType type;
    
    /** {@inheritDoc} */
    public int getId() {
        return id;
    }
    
    public T getObject() {
        return command;
    }
    
    public CommandType getType() {
        return type;
    }
    
    /** {@inheritDoc} */
    public void setId(int id) {
        this.id = id;
    }
    
    public void setObject(T command) {
        this.command = command;
    }
    
    public void setType(CommandType type) {
        this.type = type;
    }
}

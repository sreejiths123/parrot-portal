package com.parrot.portal.controller.command;


/**
 * @author tajzivit
 */
public enum CommandType {
    
    /**
     * To show form to add
     */
    ADD,
    /**
     * If you want to edit your object, mark your command with this choice
     */
    EDIT,
    
    /**
     * If you want to remove object, mark your command with this choice
     */
    REMOVE,
    
    /**
     * To show details
     */
    SHOW_DETAILS,
    
    /**
     * To show edit form
     */
    SHOW_EDIT;
}

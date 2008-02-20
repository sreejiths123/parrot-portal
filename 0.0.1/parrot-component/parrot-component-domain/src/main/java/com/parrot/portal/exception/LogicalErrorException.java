package com.parrot.portal.exception;


/**
 * @author tajzivit
 */
public class LogicalErrorException extends RuntimeException {
    
    /**
     * 
     */
    private static final long serialVersionUID = 3005823271362090326L;
    
    /**
     * 
     */
    public LogicalErrorException() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @param message
     */
    public LogicalErrorException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @param message
     * @param cause
     */
    public LogicalErrorException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @param cause
     */
    public LogicalErrorException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }
    
}

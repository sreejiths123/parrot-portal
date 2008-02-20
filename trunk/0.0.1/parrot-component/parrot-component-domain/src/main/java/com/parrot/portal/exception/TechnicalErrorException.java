package com.parrot.portal.exception;


/**
 * @author tajzivit
 */
public class TechnicalErrorException extends RuntimeException {
    
    /**
     * 
     */
    private static final long serialVersionUID = 8832957985672141781L;
    

    private ErrorType errorType;
    
    /**
     * 
     */
    public TechnicalErrorException() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @param errorType
     */
    public TechnicalErrorException(ErrorType errorType) {
        
        super(errorType.toString());
        this.errorType = errorType;
    }
    
    /**
     * @param message
     */
    public TechnicalErrorException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @param message
     * @param cause
     */
    public TechnicalErrorException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @param cause
     */
    public TechnicalErrorException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @return the errorType
     */
    public ErrorType getErrorType() {
        return errorType;
    }
    
}

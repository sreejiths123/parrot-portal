package com.parrot.portal.controller.secure;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.parrot.portal.controller.AbstractParrotCommandController;
import com.parrot.portal.controller.command.IParrotCommand;
import com.parrot.portal.exception.LogicalErrorException;
import com.parrot.portal.taglib.CollectionTag;


/**
 * @author tajzivit
 */
public abstract class AbstractModifyController<T> extends AbstractParrotCommandController {
    
    /**
     * ID of the last selected object from the collection
     */
    public static String LAST_SELECTED_OBJECT_ID = "parrot.last_selected_object_id";
    
    private HttpServletRequest currentRequest;
    
    /**
     * @param command
     */
    public abstract void doRemove(T command);
    
    /**
     * @param command
     */
    public abstract void doUpdate(T command);
    
    /**
     * @return current session
     */
    protected HttpSession getSession() {
        
        return currentRequest.getSession();
    }
    
    @SuppressWarnings("unchecked")
    @Override
    protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object cmd, BindException ex)
            throws Exception {
        
        this.currentRequest = request;
        
        IParrotCommand<T> command = (IParrotCommand<T>)cmd;
        
        switch (command.getType()) {
            case EDIT:

                validateObject(command, request);
                
                doUpdate(command.getObject());
                break;
            
            case REMOVE:

                validateObject(command, request);
                
                doRemove(command.getObject());
                break;
            
            case SHOW_EDIT:

                List<T> collection = (List<T>)request.getSession().getAttribute(CollectionTag.LAST_COLLECTION);
                command.setObject(collection.get(command.getId()));
                
                getSession().setAttribute(LAST_SELECTED_OBJECT_ID, command.getObjectsId());
                
                return new ModelAndView(getEditView(), getCommandName(), command);
        }
        
        return new ModelAndView(new RedirectView(getSuccessView()));
    }
    
    /**
     * do a validation of the given command. Id of the command has been stored before. Check the
     * value of stored id against id of given command is performed.
     * 
     * @param command
     *                to be checked
     * @param request
     *                current
     */
    private void validateObject(IParrotCommand<T> command, HttpServletRequest request) {
        
        Integer idFromSession = (Integer)getSession().getAttribute(LAST_SELECTED_OBJECT_ID);
        
        if (idFromSession == null) {
            throw new LogicalErrorException("not valid object or object id for this command - hack attempt?");
        }
        
        if (command.getObjectsId() != null && !command.getObjectsId().equals(idFromSession)) {
            throw new LogicalErrorException("not valid object or object id for this command - hack attempt?");
        } else if (command.getObjectsId() == null) {
            command.setObjectsId(idFromSession);
        }
    }
}

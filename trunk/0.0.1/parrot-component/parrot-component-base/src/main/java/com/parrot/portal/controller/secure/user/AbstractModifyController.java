package com.parrot.portal.controller.secure.user;

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
    
    /**
     * @param command
     */
    public abstract void doRemove(T command);
    
    /**
     * @param command
     */
    public abstract void doUpdate(T command);
    
    @SuppressWarnings("unchecked")
    @Override
    protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object cmd, BindException ex)
            throws Exception {
        
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
                
                getSession(request).setAttribute(LAST_SELECTED_OBJECT_ID, command.getObjectsId());
                
                return new ModelAndView(getEditView(), getCommandName(), command);
        }
        
        return new ModelAndView(new RedirectView(getSuccessView()));
    }
    
    private HttpSession getSession(HttpServletRequest request) {
        return request.getSession();
    }
    
    private void validateObject(IParrotCommand<T> command, HttpServletRequest request) {
        
        Integer idFromSession = (Integer)getSession(request).getAttribute(LAST_SELECTED_OBJECT_ID);
        

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

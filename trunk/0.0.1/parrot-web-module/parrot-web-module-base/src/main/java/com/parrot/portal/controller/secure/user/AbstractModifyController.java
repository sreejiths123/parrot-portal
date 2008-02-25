package com.parrot.portal.controller.secure.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.parrot.portal.controller.AbstractParrotCommandController;
import com.parrot.portal.controller.command.CommandType;
import com.parrot.portal.controller.command.IParrotCommand;
import com.parrot.portal.taglib.CollectionTag;


/**
 * @author tajzivit
 */
public abstract class AbstractModifyController<T> extends AbstractParrotCommandController {
    
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
        
        if (CommandType.EDIT.equals(command.getType())) {
            doUpdate(command.getCommand());
            
        } else if (CommandType.REMOVE.equals(command.getType())) {
            doRemove(command.getCommand());
            
        } else if (CommandType.SHOW_EDIT.equals(command.getType())) {
            List<T> collection = (List<T>)request.getSession().getAttribute(CollectionTag.LAST_COLLECTION);
            command.setCommand(collection.get(command.getId()));
            
            return new ModelAndView(getEditView(), getCommandName(), command);
        }
        
        return new ModelAndView(new RedirectView(getSuccessView()));
    }
}

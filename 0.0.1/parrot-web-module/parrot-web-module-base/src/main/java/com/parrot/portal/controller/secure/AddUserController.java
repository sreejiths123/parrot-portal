package com.parrot.portal.controller.secure;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.parrot.portal.domain.factory.IDomainFactory;
import com.parrot.portal.domain.factory.impl.DefaultDomainFactory;
import com.parrot.portal.domain.user.IUser;


/**
 * @author tajzivit
 */
public class AddUserController extends SimpleFormController {
    
    /** {@inheritDoc} */
    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        
        return getDomainFactory().getDomainObject(IUser.class);
    }
    
    /** {@inheritDoc} */
    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        
        boolean isUser = command instanceof IUser;
        
        if (isUser) {
            
            IUser user = (IUser)command;
            
            //save the user
        }
        
        System.out.println("redirecting to success.");
        return new ModelAndView(new RedirectView(getSuccessView()));
    }
    
    private IDomainFactory getDomainFactory() {
        return (IDomainFactory)getApplicationContext().getBean(DefaultDomainFactory.BEAN_NAME);
    }
}

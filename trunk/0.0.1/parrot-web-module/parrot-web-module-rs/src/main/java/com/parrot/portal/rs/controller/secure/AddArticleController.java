package com.parrot.portal.rs.controller.secure;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.parrot.portal.controller.AbstractParrotSimpleFormController;
import com.parrot.portal.rs.domain.IArticle;
import com.parrot.portal.rs.service.IRsService;


/**
 * @author tajzivit
 */
public class AddArticleController extends AbstractParrotSimpleFormController {
    
    private IRsService service;
    
    /**
     * @param service
     *                the service to set
     */
    public void setService(IRsService service) {
        this.service = service;
    }
    
    /** {@inheritDoc} */
    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        return getDomainFactory().getDomainObject(IArticle.class);
    }
    
    /** {@inheritDoc} */
    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        
        IArticle article = (IArticle)command;
        
        service.insert(article);
        
        return new ModelAndView(new RedirectView(getSuccessView()));
    }
}

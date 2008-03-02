package com.parrot.portal.controller.secure.rs;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.parrot.portal.controller.AbstractParrotSimpleFormController;
import com.parrot.portal.domain.rs.ICategory;
import com.parrot.portal.service.rs.IRsService;


/**
 * @author tajzivit
 */
public class AddCategoryController extends AbstractParrotSimpleFormController {
    
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
        return getDomainFactory().getDomainObject(ICategory.class);
    }
    
    /** {@inheritDoc} */
    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        
        ICategory category = (ICategory)command;
        
        service.insert(category);
        
        return new ModelAndView(new RedirectView(getSuccessView()));
    }
}

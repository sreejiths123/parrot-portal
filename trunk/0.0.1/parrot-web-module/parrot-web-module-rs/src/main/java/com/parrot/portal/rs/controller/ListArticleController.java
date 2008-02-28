package com.parrot.portal.rs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.parrot.portal.controller.AbstractParrotController;
import com.parrot.portal.rs.domain.IArticle;
import com.parrot.portal.rs.service.IRsService;


/**
 * @author tajzivit
 */
public class ListArticleController extends AbstractParrotController {
    
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
    protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
        
        List<IArticle> articles = service.getArticles();
        
        return new ModelAndView(viewName, modelName, articles);
    }
}

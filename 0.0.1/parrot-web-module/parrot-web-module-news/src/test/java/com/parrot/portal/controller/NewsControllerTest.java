/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.portal.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.test.AbstractTransactionalSpringContextTests;


/**
 * @author tajzivit
 */
public class NewsControllerTest extends ParrotAbstractSpringTest {
    
    private NewsController newsController;
    
    /**
     * @param newsController
     */
    /*public void setNewsController(NewsController newsController) {
        this.newsController = newsController;
    }*/

    /**
     * Test method for
     * {@link com.parrot.portal.controller.NewsController#handleRequestInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
     */
    @Test
    public void testHandleRequestInternalHttpServletRequestHttpServletResponse() {
        
    }
    
    /** {@inheritDoc} */
    @Override
    protected String[] getConfigLocations() {
        return new String[] { "WEB-INF/parrot-portal-news-servlet.xml" };
    }
    
}

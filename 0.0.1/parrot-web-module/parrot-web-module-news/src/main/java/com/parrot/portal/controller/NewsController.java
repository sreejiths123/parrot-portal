/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.portal.controller;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.parrot.portal.domain.core.IName;
import com.parrot.portal.domain.core.impl.Name;
import com.parrot.portal.domain.news.INews;
import com.parrot.portal.domain.news.impl.News;
import com.parrot.portal.domain.user.IUser;
import com.parrot.portal.domain.user.impl.User;


/**
 * @author tajzivit
 */
public class NewsController extends AbstractController {
    
    

    /** {@inheritDoc} */
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
        News news1 = new News();
        news1.setContent("content 1");
        news1.setHeadline("News 1");
        news1.setId(1);
        
        IUser author = new User();
        author.setId(2);
        
        IName name = new Name();
        name.setFirstName("Vitek");
        
        author.setFirstName("Vitek");
        
        news1.setAuthor(author);
        
        List<INews> newsCollection = new Vector<INews>();
        newsCollection.add(news1);
        
        return new ModelAndView("news-list", "newsCollection", newsCollection);
    }
}

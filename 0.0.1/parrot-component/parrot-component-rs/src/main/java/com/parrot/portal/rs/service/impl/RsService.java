package com.parrot.portal.rs.service.impl;

import java.util.List;

import com.parrot.portal.domain.user.IUser;
import com.parrot.portal.rs.domain.IArticle;
import com.parrot.portal.rs.domain.ICategory;
import com.parrot.portal.rs.domain.dao.IArticleDao;
import com.parrot.portal.rs.domain.dao.ICategoryDao;
import com.parrot.portal.rs.service.IRsService;


/**
 * @author tajzivit
 */
public class RsService implements IRsService {
    
    private IArticleDao articleDao;
    private ICategoryDao categoryDao;
    
    /** {@inheritDoc} */
    public void delete(IArticle article) {
        articleDao.delete(article);
    }
    
    /** {@inheritDoc} */
    public void delete(ICategory category) {
        categoryDao.delete(category);
    }
    
    /** {@inheritDoc} */
    public List<IArticle> getArticles() {
        return articleDao.list();
    }
    
    /** {@inheritDoc} */
    public List<IArticle> getArticles(IUser author) {
        //TODO: list by criteria - named query perhaps
        return articleDao.list();
    }
    
    /** {@inheritDoc} */
    public List<ICategory> getCategories() {
        return categoryDao.list();
    }
    
    /** {@inheritDoc} */
    public IArticle insert(IArticle article) {
        
        articleDao.create(article);
        
        return article;
    }
    
    /** {@inheritDoc} */
    public ICategory insert(ICategory category) {
        
        categoryDao.create(category);
        
        return category;
    }
    
    /**
     * @param articleDao
     *                the articleDao to set
     */
    public void setArticleDao(IArticleDao articleDao) {
        this.articleDao = articleDao;
    }
    
    /**
     * @param categoryDao
     *                the categoryDao to set
     */
    public void setCategoryDao(ICategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }
    
    /** {@inheritDoc} */
    public IArticle update(IArticle article) {
        
        articleDao.update(article);
        
        return article;
    }
    
    /** {@inheritDoc} */
    public ICategory update(ICategory category) {
        
        categoryDao.update(category);
        
        return category;
    }
}

package com.parrot.portal.service.rs;

import java.util.List;

import com.parrot.portal.domain.rs.IArticle;
import com.parrot.portal.domain.rs.ICategory;
import com.parrot.portal.domain.user.IUser;


/**
 * @author tajzivit
 */
public interface IRsService {
    
    /**
     * @param article
     *                will be deleted
     */
    void delete(IArticle article);
    
    /**
     * @param category
     *                will be deleted
     */
    void delete(ICategory category);
    
    /**
     * @return list of all articles
     */
    List<IArticle> getArticles();
    
    /**
     * @param author
     * @return list of all articles for given author
     */
    List<IArticle> getArticles(IUser author);
    
    /**
     * @return list of all categories
     */
    List<ICategory> getCategories();
    
    /**
     * @param article
     *                to be saved
     * @return inserted article
     */
    IArticle insert(IArticle article);
    
    /**
     * @param category
     *                to be saved
     * @return inserted category
     */
    ICategory insert(ICategory category);
    
    /**
     * @param article
     *                to be updated
     * @return updated article
     */
    IArticle update(IArticle article);
    
    /**
     * @param category
     *                to be updated
     * @return updated category
     */
    ICategory update(ICategory category);
}

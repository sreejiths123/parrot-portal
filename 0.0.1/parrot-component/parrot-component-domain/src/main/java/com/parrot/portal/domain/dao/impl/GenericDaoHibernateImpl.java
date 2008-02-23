package com.parrot.portal.domain.dao.impl;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.parrot.portal.domain.dao.GenericDao;
import com.parrot.portal.domain.dao.finder.FinderArgumentTypeFactory;
import com.parrot.portal.domain.dao.finder.FinderExecutor;
import com.parrot.portal.domain.dao.finder.FinderNamingStrategy;
import com.parrot.portal.domain.dao.finder.impl.SimpleFinderArgumentTypeFactory;
import com.parrot.portal.domain.dao.finder.impl.SimpleFinderNamingStrategy;

/**
 * Hibernate implementation of GenericDao A type safe implementation of CRUD and finder methods
 * based on Hibernate and Spring AOP The finders are implemented through the executeFinder method.
 * Normally called by the FinderIntroductionInterceptor
 */
public class GenericDaoHibernateImpl<T, PK extends Serializable> implements GenericDao<T, PK>, FinderExecutor {
    
    private FinderArgumentTypeFactory argumentTypeFactory = new SimpleFinderArgumentTypeFactory(); // Default. Can override in config
    private FinderNamingStrategy namingStrategy = new SimpleFinderNamingStrategy(); // Default. Can override in config
    private SessionFactory sessionFactory;
    
    private Class<T> type;
    
    public GenericDaoHibernateImpl(Class<T> type) {
        this.type = type;
    }
    
    @SuppressWarnings("unchecked")
    public PK create(T o) {
        return (PK)getSession().save(o);
    }
    
    public void delete(T o) {
        getSession().delete(o);
    }
    
    @SuppressWarnings("unchecked")
    public List<T> executeFinder(Method method, final Object[] queryArgs) {
        final Query namedQuery = prepareQuery(method, queryArgs);
        return namedQuery.list();
    }
    
    public FinderArgumentTypeFactory getArgumentTypeFactory() {
        return argumentTypeFactory;
    }
    
    public FinderNamingStrategy getNamingStrategy() {
        return namingStrategy;
    }
    
    public Session getSession() {
        boolean allowCreate = true;
        return SessionFactoryUtils.getSession(sessionFactory, allowCreate);
    }
    
    //    public ScrollableResults scrollFinder(Method method, final Object[] queryArgs)
    //    {
    //        final Query namedQuery = prepareQuery(method, queryArgs);
    //        return (ScrollableResults) namedQuery.scroll();
    //    }
    
    @SuppressWarnings("unchecked")
    public Iterator<T> iterateFinder(Method method, final Object[] queryArgs) {
        final Query namedQuery = prepareQuery(method, queryArgs);
        return namedQuery.iterate();
    }
    
    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    public List<T> list() {
        return getSession().createCriteria(type).list();
    }
    
    @SuppressWarnings("unchecked")
    public T read(PK id) {
        return (T)getSession().get(type, id);
    }
    
    public void setArgumentTypeFactory(FinderArgumentTypeFactory argumentTypeFactory) {
        this.argumentTypeFactory = argumentTypeFactory;
    }
    
    public void setNamingStrategy(FinderNamingStrategy namingStrategy) {
        this.namingStrategy = namingStrategy;
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void update(T o) {
        getSession().update(o);
    }
    
    private Query prepareQuery(Method method, Object[] queryArgs) {
        final String queryName = getNamingStrategy().queryNameFromMethod(type, method);
        final Query namedQuery = getSession().getNamedQuery(queryName);
        String[] namedParameters = namedQuery.getNamedParameters();
        if (namedParameters.length == 0) {
            setPositionalParams(queryArgs, namedQuery);
        } else {
            setNamedParams(namedParameters, queryArgs, namedQuery);
        }
        return namedQuery;
    }
    
    private void setNamedParams(String[] namedParameters, Object[] queryArgs, Query namedQuery) {
        // Set parameter. Use custom Hibernate Type if necessary
        if (queryArgs != null) {
            for (int i = 0; i < queryArgs.length; i++) {
                Object arg = queryArgs[i];
                Type argType = getArgumentTypeFactory().getArgumentType(arg);
                if (argType != null) {
                    namedQuery.setParameter(namedParameters[i], arg, argType);
                } else {
                    if (arg instanceof Collection) {
                        namedQuery.setParameterList(namedParameters[i], (Collection)arg);
                    } else {
                        namedQuery.setParameter(namedParameters[i], arg);
                    }
                }
            }
        }
    }
    
    private void setPositionalParams(Object[] queryArgs, Query namedQuery) {
        // Set parameter. Use custom Hibernate Type if necessary
        if (queryArgs != null) {
            for (int i = 0; i < queryArgs.length; i++) {
                Object arg = queryArgs[i];
                Type argType = getArgumentTypeFactory().getArgumentType(arg);
                if (argType != null) {
                    namedQuery.setParameter(i, arg, argType);
                } else {
                    namedQuery.setParameter(i, arg);
                }
            }
        }
    }
}

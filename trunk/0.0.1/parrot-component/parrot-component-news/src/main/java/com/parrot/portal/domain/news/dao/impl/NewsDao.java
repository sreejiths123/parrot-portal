package com.parrot.portal.domain.news.dao.impl;

import java.util.List;

import com.parrot.portal.domain.dao.GenericDao;
import com.parrot.portal.domain.news.INews;

public interface NewsDao extends GenericDao<INews, Integer> {

	List<INews> findByHeadline(String name);
	
	
}

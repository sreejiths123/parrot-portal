package com.parrot.portal.domain.user.dao;

import java.util.List;

import com.parrot.dao.GenericDao;
import com.parrot.portal.domain.user.ITask;

public interface ITaskDao extends GenericDao<ITask, Integer> {

	List<ITask> findByModuleId(int id);

	List<ITask> findByModuleName(String name);

}

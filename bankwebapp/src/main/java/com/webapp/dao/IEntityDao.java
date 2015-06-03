package com.webapp.dao;

import java.util.List;

public interface IEntityDao<T> {

	void create(T object);

	void update(T object);

	void delete(T object);

	T findById(long id);

	List<T> findAll();

}

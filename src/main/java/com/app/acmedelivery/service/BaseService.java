package com.app.acmedelivery.service;

import com.app.acmedelivery.domainModel.BaseModel;
import com.app.acmedelivery.domainModel.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BaseService<T extends BaseModel> {
	T create(final T entity);

	List<T> createAll(final T... entities);

	List<T> createAll(final List<T> entities);

	void update(T entity);

	void delete(T entity);

	void deleteById(Long id);

	boolean exists(T entity);

	T get(Long id);

	List<T> findAll();


}

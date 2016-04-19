package com.br.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.br.model.EntityClass;

public abstract class GenericDAO<T extends EntityClass> {
	
	protected EntityManager manager;
	
	public GenericDAO(EntityManager manager) {
		this.manager = manager;
	}

	public void insert(T entity){
		manager.persist(entity);
	}
	
	public T findById(Long id){
		return manager.find(getClassType(), id);
	}
	
	public void update(T entity){
		manager.merge(entity);
	}
	
	public void delete(T entity){
		entity = findById(entity.getId());
		manager.remove(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		Query query = manager.createQuery("select p from "
				+ getClassType().getSimpleName() + " p");
		return  query.getResultList();
	}
	
	public abstract Class<T> getClassType();
}

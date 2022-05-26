package br.com.unisep.controlepassagens.shared;

import java.util.List;

public interface Repository<T> {
	
	T insert(T entity);
	
	T update(T entity);
	
	void delete(int id);
	
	T findOne(int id);
	
	List<T> findAll();

}

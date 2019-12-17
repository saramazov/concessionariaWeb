package concessionaria.dao;

import java.util.Collection;

import concessionaria.db.ConcessionariaException;

public interface Dao<T> {
	
	T create(T t) throws ConcessionariaException;
	
	Collection<T> findAll() throws ConcessionariaException;
	
	T findById(Long id) throws ConcessionariaException;
	
	int remove(Long id) throws ConcessionariaException;
	
	int remove(T t) throws ConcessionariaException;
	
	int update(T t) throws ConcessionariaException;
	
}

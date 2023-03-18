package com.training.inventory.controller;

import java.util.List;

public interface IController<T> {
	
	
	List<T> findAll() throws Exception ;
	T findOneById(long id) throws Exception ;
	T create(T t) throws Exception ;
	boolean update(long id, T t) throws Exception ;
	boolean delete(long id) throws Exception ;

}

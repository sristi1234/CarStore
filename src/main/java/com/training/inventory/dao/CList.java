package com.training.inventory.dao;

import java.sql.SQLException;
import java.util.List;

public interface CList<T> {

	List<T> findAll() throws SQLException;

	T findById(long id) throws SQLException;

	T create(T t) throws SQLException;

	boolean update(long id, T t) throws SQLException;

	boolean delete(long id) throws SQLException;

}

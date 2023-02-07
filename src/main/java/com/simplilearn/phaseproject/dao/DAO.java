package com.simplilearn.phaseproject.dao;

import java.util.List;

public interface DAO<T> {
	
	    //get all records
		List<T> getAll();

		//get one record
		T getOne(long id);

		// create a record
		int save(T object);

		// update a record
		int update (T object);

		// delete a record
		int delete(long id);



}

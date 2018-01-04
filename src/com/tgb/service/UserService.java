package com.tgb.service;

import java.util.List;

import com.tgb.model.User;


public interface UserService {
	void save(User user);
	boolean update(User user);
	boolean delete(int id);
	User findById(int id);
	List<User> findAll();
}

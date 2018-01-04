package com.tgb.service;

import java.util.List;

import com.tgb.model.User;


public interface AdminService {
	List<User> findAll();

	User getUserInfoById(int id);
}

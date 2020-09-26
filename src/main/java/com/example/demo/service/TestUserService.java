package com.example.demo.service;

import java.util.List;

import com.example.demo.model.TestUser;

public interface TestUserService {

	//增
	public int addUser(TestUser user);
	//删
	public int deleteUser(int id);
	//改	
	public int updateUser(TestUser user);
	//查	
	public List<TestUser> getUser();
	
}

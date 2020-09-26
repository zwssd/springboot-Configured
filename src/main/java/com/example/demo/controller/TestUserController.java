package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TestUser;
import com.example.demo.service.TestUserService;

@RestController
@RequestMapping("/user")
public class TestUserController{

	@Autowired
	private TestUserService testUserService;
	
	//增
	@RequestMapping("/addUser")
	public int addUser(){
		//向数据库添加两条记录
		TestUser user = new TestUser();
		user.setName("zhang san ");
		user.setPassword("123456");	
		
		TestUser user1 = new TestUser();
		user1.setName("li si");
		user1.setPassword("123456");	
		int result = testUserService.addUser(user);
		int result1 = testUserService.addUser(user1);
		
		return result & result1;
	}

	//删
	@RequestMapping("/deleteUser")
	public int deleteUser(){
		//删除数据中中第一条记录
		int result = testUserService.deleteUser(1);
		return result;
	}
	
	@RequestMapping("/updataUser")
	public int updateUser(){
		//修改数据库中第二条记录
		TestUser user = new TestUser();
		user.setId(2);
		user.setName("chen er");
		user.setPassword("123");
		int result = testUserService.updateUser(user);	
		return result;
	}
	
	@RequestMapping("/showUser")
	public List<TestUser> getUserInfo(){
		//System.out.println("getUserInfo");
		//查询数据库user表中所有记录
		List<TestUser> user = testUserService.getUser();
		return user;
	}
	
}
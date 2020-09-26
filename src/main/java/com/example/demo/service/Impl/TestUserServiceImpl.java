package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TestUserMapper;
import com.example.demo.model.TestUser;
import com.example.demo.service.TestUserService;

@Service
public class TestUserServiceImpl  implements TestUserService {

	@Autowired
	private TestUserMapper dao;
	
	//增
	@Override
	public int addUser(TestUser user) {
		
		int result = 0;
		try{
			result = dao.insert(user);
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		return result;
	}
 
	
	//删
	@Override
	public int deleteUser(int id) {
		
		int	result =0;
		try {
			result = dao.deleteByPrimaryKey(id);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return result;
	}
	//改
	@Override
	public int updateUser(TestUser user) {
		int result = 0;
		
		try {
			result = dao.updateByPrimaryKey(user);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return result;
	}
 
	//查
	@Override
	public List<TestUser> getUser() {
		return dao.selectAllInfo();
	}
	
}

package com.tgb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tgb.mapper.UserMapper;
import com.tgb.model.Material;
import com.tgb.model.Tool;
import com.tgb.model.User;
import com.tgb.service.UserService;



@Service("userService")
@Transactional  //此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper mapper;

	public boolean delete(int id) {
		
		return mapper.delete(id);
	}

	public List<User> findAll() {
		List<User> findAllList = mapper.findAll();
		//测试mybatis高级关联关系
		User user = mapper.findUserAndTool(1);
		if(user!=null&&user.getToolList()!=null){
			for(Tool t:user.getToolList()){
				System.out.print(t.getId()+":"+t.getTool_name()+"->材料:");
				if(t.getMaterialList()!=null){
					for(Material m : t.getMaterialList()){
						System.out.print(m.getMat_type()+" ");
					}
					System.out.println();
				}
			}
		}
		return findAllList;
	}

	public User findById(int id) {

		User user = mapper.findById(id);
		
		return user;
	}

	public void save(User user) {

		mapper.save(user);
	}

	public boolean update(User user) {

		return mapper.update(user);
	}
	
	

}
